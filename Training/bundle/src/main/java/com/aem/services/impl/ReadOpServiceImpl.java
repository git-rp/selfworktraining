package com.aem.services.impl;

import com.aem.services.ReadOpService;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.*;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vivek on 21/12/14.
 */
@Service
@Component(immediate = true)
public class ReadOpServiceImpl implements ReadOpService {

    private final Logger logger = LoggerFactory.getLogger(ReadOpServiceImpl.class);

    @Reference
    private ResourceResolverFactory resolverFactory;

    @Override
    public void readPropFromNode(String resourcePatb) {
        Map<String, Object> serviceParams = new HashMap<String, Object>();
        serviceParams.put(ResourceResolverFactory.SUBSERVICE, "readService");
        ResourceResolver resolver = null;
        try {
            resolver = resolverFactory.getServiceResourceResolver(serviceParams);
            logger.info(resolver.getUserID());
            Resource res = resolver.getResource(resourcePatb+"/jcr:content");
            logger.info("Path is ::: "+res.getPath());
            ModifiableValueMap modMap = res.adaptTo(ModifiableValueMap.class);
            if(modMap != null){
                modMap.put("propname", "propValue");
                resolver.commit();
                logger.info("Successfully saved");
            }
        } catch (Exception e) {
            logger.error("Exceptions is ::: ",e);
        }finally{
            if(resolver != null){
                resolver.close();
            }
        }
    }


}
