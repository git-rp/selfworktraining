package com.aem.services.impl;

import com.aem.services.DemoService;
import org.apache.felix.scr.annotations.*;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Created by vivek on 7/1/15.
 */
@Component(metatype = true, immediate = true, description = "Demo Service to test")
@Service(value = DemoService.class)
@Properties({
        @Property(name = "testprop" , value = "This is Test Property")
})
public class DemoServiceImpl implements DemoService {
    private static final Logger logger = LoggerFactory.getLogger(LoginAccessImpl.class);

     @Property(name = "localprop", value = "Local Value")

    private ServiceRegistration ppcService;
    @Override
    public void demoMethod() {
        logger.info("::::::::::DEMO SERVICE CALLED:::::::::::");


    }
    @Activate
    public void activate(ComponentContext ctx)
    {
        String testprop = (String)ctx.getProperties().get("testprop");
        String localprop = (String)ctx.getProperties().get("localprop");
        logger.info(testprop +" ::::::::: "+localprop);

    }

}
