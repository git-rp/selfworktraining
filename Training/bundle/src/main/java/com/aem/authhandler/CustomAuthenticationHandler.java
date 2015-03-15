package com.aem.authhandler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.auth.core.spi.AuthenticationFeedbackHandler;
import org.apache.sling.auth.core.spi.AuthenticationHandler;
import org.apache.sling.auth.core.spi.AuthenticationInfo;
import org.apache.sling.auth.core.spi.DefaultAuthenticationFeedbackHandler;
@Component(metatype = true, immediate = true, label = "Custom Auth Handler",
        description="Authenticates User Against a REST Service")
@Service
@Properties({
        @Property(name = AuthenticationHandler.PATH_PROPERTY, value = "/content/aemproject/parent/child0/j_custom_security_check"),
        @Property(name = AuthenticationHandler.TYPE_PROPERTY, value = CustomAuthenticationHandler.AUTH_TYPE, propertyPrivate = true),
        @Property(name = Constants.SERVICE_VENDOR, value = "Custom"),
        @Property(name = Constants.SERVICE_DESCRIPTION, value = "Custom Auth Handler") })
public class CustomAuthenticationHandler extends
        DefaultAuthenticationFeedbackHandler implements AuthenticationHandler,
        AuthenticationFeedbackHandler {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    protected static final String AUTH_TYPE = "CUSTOM_AUTH";

    private ServiceRegistration loginModule;

    @Activate
    protected void activate(ComponentContext componentContext) {

        log.debug("*** CustomAuthenticationHandler activate ***");

        try {
            this.loginModule = CustomLoginModule.register(this,
                    componentContext.getBundleContext());
        } catch (Throwable t) {
            log.error("Error while activating CustomAuthenticationHandler!!!", t);
        }

    }

    @Override
    public void dropCredentials(HttpServletRequest request,
                                HttpServletResponse response) throws IOException {
        log.debug("*** CustomAuthenticationHandler dropCredentials ***");
    }

    @Override
    public AuthenticationInfo extractCredentials(HttpServletRequest request,
                                                 HttpServletResponse response) {
        log.debug("*** CustomAuthenticationHandler extractCredentials ***");
        AuthenticationInfo authInfo = new AuthenticationInfo(CustomAuthenticationHandler.AUTH_TYPE, "userId", "pwd".toCharArray());
        return authInfo;
    }

    @Override
    public boolean requestCredentials(HttpServletRequest request,
                                      HttpServletResponse response) throws IOException {
        log.debug("*** CustomAuthenticationHandler requestCredentials ***");
        response.sendRedirect("/");
        return true;
    }

    @Override
    public boolean authenticationSucceeded(HttpServletRequest request,
                                           HttpServletResponse response, AuthenticationInfo authInfo) {
        log.debug("*** CustomAuthenticationHandler authenticationSucceeded ***");
        return super.authenticationSucceeded(request, response, authInfo);
    }

    @Override
    public void authenticationFailed(HttpServletRequest request,
                                     HttpServletResponse response, AuthenticationInfo authInfo) {
        log.debug("*** CustomAuthenticationHandler authenticationFailed ***");
        super.authenticationFailed(request, response, authInfo);
    }
}