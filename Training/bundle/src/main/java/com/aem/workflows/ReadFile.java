package com.aem.workflows;

import com.day.cq.workflow.WorkflowException;
import com.day.cq.workflow.WorkflowSession;
import com.day.cq.workflow.exec.WorkItem;
import com.day.cq.workflow.exec.WorkflowData;
import com.day.cq.workflow.exec.WorkflowProcess;
import com.day.cq.workflow.metadata.MetaDataMap;
import org.apache.felix.scr.annotations.*;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.framework.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.PropertyType;
import javax.jcr.Session;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Created by vivek on 10/2/15.
 */
@Component(metatype = false)
@Service
@Properties({
        @Property(name = "service.description", value = "Reading File."),
        @Property(name = "service.vendor", value = "Adobe"),
        @Property(name = "process.label", value = "Blog Process")
})
public class ReadFile implements WorkflowProcess {
    @Reference
    ResourceResolverFactory resolverFactory;

    private static final Logger logger = LoggerFactory.getLogger(ReadFile.class);
    public void execute(WorkItem item, WorkflowSession session, MetaDataMap args) throws WorkflowException {
        WorkflowData workflowData = item.getWorkflowData();
        if (workflowData.getPayloadType().equals("JCR_PATH")) {
            String path = workflowData.getPayload().toString();
            logger.info("path is :::: "+path);
            try {
                ResourceResolver resourceResolver = resolverFactory.getAdministrativeResourceResolver(null);
                Node dataNode = resourceResolver.getResource(path).adaptTo(Node.class);
                Session sess = resourceResolver.adaptTo(Session.class);
                logger.info("Data Node is ::: "+dataNode.getPath());
                /*InputStream is = dataNode.getProperty("jcr:data").getBinary().getStream();
                BufferedInputStream bis = new BufferedInputStream(is);
                ByteArrayOutputStream buf = new ByteArrayOutputStream();
                int resultNumber = bis.read();
                while (resultNumber != -1) {
                    byte b = (byte) resultNumber;
                    buf.write(b);
                   logger.info("Text :: "+(char)b);
                    resultNumber = bis.read();

                }*/
                dataNode.setProperty("newName", "123", PropertyType.STRING);
                sess.save();


            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
