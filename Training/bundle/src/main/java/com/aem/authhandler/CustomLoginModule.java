package com.aem.authhandler;
import java.security.Principal;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import javax.jcr.Credentials;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;

import org.apache.sling.jcr.jackrabbit.server.security.AuthenticationPlugin;
import org.apache.sling.jcr.jackrabbit.server.security.LoginModulePlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomLoginModule implements LoginModulePlugin {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * The {@link CustomAuthenticationHandler} used to validate the credentials
     * and its contents.
     */
    private final CustomAuthenticationHandler authHandler;

    /**
     * Creates an instance of this class and registers it as a
     * <code>LoginModulePlugin</code> service to handle login requests with
     * <code>SimpleCredentials</code> provided by the
     * {@link CustomAuthenticationHandler}.
     *
     * @param authHandler The {@link CustomAuthenticationHandler} providing
     *            support to validate the credentials
     * @param bundleContext The <code>BundleContext</code> to register the
     *            service
     * @return The <code>ServiceRegistration</code> of the registered service for
     *         the {@link CustomAuthenticationHandler} to unregister the service
     *         on shutdown.
     */
    static ServiceRegistration register(
            final CustomAuthenticationHandler authHandler,
            final BundleContext bundleContext) {
        CustomLoginModule plugin = new CustomLoginModule(authHandler);

        Hashtable<String, Object> properties = new Hashtable<String, Object>();

        properties.put(Constants.SERVICE_DESCRIPTION,
                "LoginModulePlugin Support for CustomAuthenticationHandler");

        return bundleContext.registerService(LoginModulePlugin.class.getName(),
                plugin, properties);
    }

    /**
     * Private constructor called from
     * {@link #register(CustomAuthenticationHandler, BundleContext)} to create an
     * instance of this class.
     *
     * @param authHandler The {@link CustomAuthenticationHandler} used to validate
     *            the credentials attribute
     */
    private CustomLoginModule(final CustomAuthenticationHandler authHandler) {
        this.authHandler = authHandler;
    }

    @Override
    public boolean canHandle(Credentials arg0) {
        log.debug("*** CustomLoginModule canHandle ***");
        return true;
    }

    @Override
    public void doInit(CallbackHandler arg0, Session arg1, Map arg2)
            throws LoginException {
        log.debug("*** CustomLoginModule doInit ***");
    }

    @Override
    public AuthenticationPlugin getAuthentication(Principal arg0,
                                                  Credentials arg1) throws RepositoryException {
        log.debug("*** CustomLoginModule getAuthentication ***");

        return new AuthenticationPlugin() {
            public boolean authenticate(Credentials credentials)
                    throws RepositoryException {
                log.debug("*** CustomLoginModule authenticate ***");
                return true;
            }

        };
    }

    @Override
    public Principal getPrincipal(Credentials arg0) {
        log.debug("*** CustomLoginModule getPrincipal ***");
        return null;
    }

    @Override
    public void addPrincipals(Set set) {

    }


    @Override
    public int impersonate(Principal arg0, Credentials arg1)
            throws RepositoryException, FailedLoginException {
        log.debug("*** CustomLoginModule impersonate ***");
        return 0;
    }

}