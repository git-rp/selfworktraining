package com.aem.services.impl;

import com.aem.services.LoginAccessService;
import org.apache.felix.scr.annotations.*;
import org.apache.sling.jcr.api.SlingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

/**
 * Created by vivek on 16/12/14.
 */
@Component(metatype = true , immediate = true, createPid = false)
@Service(value = LoginAccessService.class)
@Properties({
        @Property(name = "service.vendor", value = "Vivek.dhiman"),
        @Property(name = "service.description", value = "Login Access Testing")
})
public class LoginAccessImpl implements LoginAccessService {

    private static final Logger logger = LoggerFactory.getLogger(LoginAccessImpl.class);
    @Reference
    protected SlingRepository repository;

    @Override
    public Node createNode(String path) {
       /* try {
         Session session =   repository.loginService(null,repository.getDefaultWorkspace());
            logger.info(session.getUserID());
        } catch (RepositoryException e) {
            e.printStackTrace();
        }*/
        return null;
    }
}
