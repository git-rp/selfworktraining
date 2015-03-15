package com.aem.sightly;


import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * Created by vivek on 23/1/15.
 */
@Model(adaptables=SlingHttpServletRequest.class)
public class DateFormatting {
    //Logger logger = LoggerFactory.getLogger(DateFormatting.class);
    @Inject
    private Calendar date;

    @Inject
    private String dateFormat;

    public String formattedValue;

    @PostConstruct
    protected void init() {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        formattedValue = formatter.format(date.getTime());
    }

}