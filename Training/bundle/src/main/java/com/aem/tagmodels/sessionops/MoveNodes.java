package com.aem.tagmodels.sessionops;


import org.apache.felix.scr.annotations.Reference;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.scripting.SlingScriptHelper;
import org.apache.sling.jcr.api.SlingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by vivek on 17/12/14.
 */
public class MoveNodes extends SimpleTagSupport {
    private static final Logger logger = LoggerFactory.getLogger(MoveNodes.class);

    String source;
    String destination;


    public void setSource(String source) {
        this.source = source;
    }


    public void setDestination(String destination) {
        this.destination = destination;
    }


    public void doTag()
    {
        try {
            /*logger.info("inside tag::"+repository);
            Resource resource = (Resource) getJspContext().getAttribute("resource");
            Session session1 = resource.getResourceResolver().adaptTo(Session.class);
            logger.info("Session -------> "+session1.getUserID());
            session1.move(source,destination);
            session1.save();*/
            SlingScriptHelper sling = (SlingScriptHelper)getJspContext().getAttribute("sling");
            ResourceResolverFactory resolverFactory = sling.getService(ResourceResolverFactory.class);
            logger.info("resolverFactory ::: "+resolverFactory);
            Map<String, Object> param = new HashMap<String, Object>();
            param.put(ResourceResolverFactory.SUBSERVICE, "datawrite");
            ResourceResolver resolver = null;
            //Invoke the adaptTo method to create a Session used to create a QueryManager
            resolver = resolverFactory.getServiceResourceResolver(param);
            logger.info("resolver ::: "+resolver);
            Session session = resolver.adaptTo(Session.class);
            logger.info(session.toString());


        }
        catch (Exception e){
            logger.error("error is "+e.getMessage());
        }

    }
}
