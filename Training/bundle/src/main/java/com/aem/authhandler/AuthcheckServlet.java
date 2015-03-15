package com.aem.authhandler;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Session;

/**
 * Created by vivek on 10/2/15.
 */
@Component(metatype=false)
@Service
public class AuthcheckServlet extends SlingSafeMethodsServlet {

    @Property(value="/bin/permissioncheck")
    static final String SERVLET_PATH="sling.servlet.paths";

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void doHead(SlingHttpServletRequest request, SlingHttpServletResponse response) {
        try {
            logger.info("::::Inside AuthCheck:::::");
            //retrieve the requested URL
            String uri = request.getParameter("uri");
            logger.info("uri is "+uri);
            //obtain the session from the request
           Session session = request.getResourceResolver().adaptTo(javax.jcr.Session.class);
            //perform the permissions check
            try {
                session.checkPermission(uri, Session.ACTION_READ);
                response.setStatus(SlingHttpServletResponse.SC_OK);
               } catch (Exception e) {
               logger.info("authchecker says READ access DENIED!");
               response.setStatus(SlingHttpServletResponse.SC_FORBIDDEN);
               }
            } catch (Exception e) {
           logger.error("authchecker servlet exception: " + e.getMessage());
            }
        }
}
