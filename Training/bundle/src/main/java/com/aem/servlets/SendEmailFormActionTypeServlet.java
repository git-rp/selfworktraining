package com.aem.servlets;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by intelligrape on 3/3/15.
 */
@SlingServlet(

        description = "My Awesome All Powerful Servlet",
        resourceTypes = { "sling/servlet/default" },
        generateService = true,
        generateComponent = true,
        label = "No, really. THIS is the only Servlet you will ever need...",
        metatype = true,
        name = "com.aem.servlets.SendEmailFormActionTypeServlet",
        selectors = { "custommail" }

)
public class SendEmailFormActionTypeServlet extends SlingAllMethodsServlet{
    static final Logger logger = LoggerFactory.getLogger(SendEmailFormActionTypeServlet.class);
    public void doGet(SlingHttpServletRequest request,SlingHttpServletResponse response){
        logger.info(":::::::::Custom Email:::::::");
    }
}
