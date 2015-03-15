package com.aem.importers;

import com.day.cq.polling.importer.ImportException;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import com.day.cq.polling.importer.Importer;
import org.apache.sling.api.resource.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by vivek on 21/1/15.
 */
@Service(value = Importer.class)
@Component(immediate = true)
@Property(name = "importer.scheme", value = "" +
        "", propertyPrivate = true)
public class CustomImporter implements Importer {

    Logger logger = LoggerFactory.getLogger(CustomImporter.class);
    @Override
    public void importData(String s, String s2, Resource resource) throws ImportException {
        logger.info("::::::::::::::CUSTOM IMPORTER ::::::::::::::::");

    }
}
