package com.aem.PredicateGroup;

import java.util.Comparator;
import javax.jcr.query.Row;
import org.apache.felix.scr.annotations.Component;
import org.apache.sling.api.resource.ValueMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.search.Predicate;
import com.day.cq.search.eval.AbstractPredicateEvaluator;
import com.day.cq.search.eval.EvaluationContext;
/**
 * Custom class to support case sensitive compare
 * path=
 * type=
 * customcase.property=
 * {optional} customcase.fulltext=
 * customcase.case=upper/lower/UPPER/LOWER/no_case/NO_CASE
 * orderby=customcase
 * @author yogeshupadhyay
 *
 */
@Component(metatype =false,  factory="com.day.cq.search.eval.PredicateEvaluator/customcase")
public class CustomCasePredicate extends AbstractPredicateEvaluator {
    private static final Logger logger = LoggerFactory.getLogger(CustomCasePredicate.class);
    public static final String PROPERTY = "property";
    public static final String FULL_TEXT = "fulltext";
    public static final String CASE = "case";
    public static final String LOWER_CASE = "lower";
    public static final String UPPER_CASE = "upper";
    public static final String NO_CASE = "no_case";
    @Override
    public boolean includes(Predicate predicate, Row row,
                            EvaluationContext context) {
        if(predicate.hasNonEmptyValue(PROPERTY)){
            return true;
        }
        return super.includes(predicate, row, context);
    }
    /**
     * Create custom Xpath expression based on property
     */
    @Override
    public String getXPathExpression(Predicate predicate,
                                     EvaluationContext context) {
        if(!predicate.hasNonEmptyValue(PROPERTY)){
            return null;
        }
        if(predicate.hasNonEmptyValue(PROPERTY) && null==predicate.get(FULL_TEXT)){
            return super.getXPathExpression(predicate, context);
        }
        if(predicate.get(CASE).equalsIgnoreCase(LOWER_CASE)){
            return "fn:lower-case(@"+predicate.get(PROPERTY)+")='"+predicate.get(FULL_TEXT)+"'";
        }
        if(predicate.get(CASE).equalsIgnoreCase(UPPER_CASE)){
            return "fn:upper-case(@"+predicate.get(PROPERTY)+")='"+predicate.get(FULL_TEXT)+"'";
        }
        if(predicate.get(CASE).equalsIgnoreCase(NO_CASE)){
            return "fn:lower-case(@"+predicate.get(PROPERTY)+")='"+predicate.get(FULL_TEXT).toLowerCase()+"'";
        }
// TODO Auto-generated method stub
        return super.getXPathExpression(predicate, context);
    }

    /**
     * Some workaround is done to handle multi value property
     * Multivalue is sorted based on first value in Array
     */
    @Override
    public Comparator<Row> getOrderByComparator(final Predicate predicate, final EvaluationContext context) {
        return new Comparator<Row>() {
            public int compare(Row r1, Row r2) {
                String[] property1;
                String[] property2;
                try {
                    if(null!=r1&&null!=r2&&null!=predicate.get(PROPERTY)){
                        ValueMap valueMap1 = context.getResource(r1).adaptTo(ValueMap.class);
                        ValueMap valueMap2 = context.getResource(r2).adaptTo(ValueMap.class);
                        property1 = valueMap1.get(predicate.get(PROPERTY),String[].class);
                        property2 =valueMap2.get(predicate.get(PROPERTY),String[].class);
                        boolean isCompare = null!=property1 && null!=property2;
                        if(isCompare) logger.debug("value    "+ property1[0] + "   "+ property2[0]);
                        if(isCompare && predicate.get(CASE).equalsIgnoreCase(LOWER_CASE)){
                            return property1[0].toLowerCase().compareTo(property2[0].toLowerCase());
                        }
                        if(isCompare && predicate.get(CASE).equalsIgnoreCase(UPPER_CASE)){
                            return property1[0].toUpperCase().compareTo(property2[0].toUpperCase());
                        }else{
                            return isCompare ? property1[0].compareToIgnoreCase(property2[0]):1;
                        }
                    }
                } catch (Exception e) {
                    logger.error(e.getMessage());
                    e.printStackTrace();
                }
                return 1;
            }

        };
    }

}