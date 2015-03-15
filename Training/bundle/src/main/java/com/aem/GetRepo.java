package com.aem;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.jackrabbit.commons.JcrUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.jcr.api.SlingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.*;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by vivek on 8/2/15.
 */

@SlingServlet(
        paths = "/bin/crx/bootcamp"
)
public class GetRepo extends SlingAllMethodsServlet {
    @Reference
    private Repository repository;
    Logger logger = LoggerFactory.getLogger(GetRepo.class);
    public void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException

    {
        logger.info(":::::Inside doPost:::::::");
        response.setContentType("text/html");
        try {
            javax.jcr.Session session = repository.login(new SimpleCredentials("admin", "admin".toCharArray()));

            session.logout();
        }
        catch (Exception e){
            e.printStackTrace();
        }



    }

}
