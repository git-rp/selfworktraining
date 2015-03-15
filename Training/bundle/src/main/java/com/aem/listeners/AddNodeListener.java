package com.aem.listeners;

/**
 * Created by vivek on 26/12/14.
 */

    import java.util.Arrays;

    import javax.jcr.Node;
    import javax.jcr.RepositoryException;
    import javax.jcr.Session;
    import javax.jcr.observation.Event;
    import javax.jcr.observation.EventIterator;
    import javax.jcr.observation.EventListener;
    import javax.jcr.observation.ObservationManager;

    import org.apache.felix.scr.annotations.*;
    import org.apache.sling.api.resource.LoginException;
    import org.apache.sling.api.resource.ResourceResolver;
    import org.apache.sling.api.resource.ResourceResolverFactory;
    import org.apache.sling.jcr.api.SlingRepository;
    import org.osgi.framework.BundleContext;
    import org.osgi.service.component.ComponentContext;
    import org.osgi.service.event.EventHandler;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;

    @Service
    @Component(metatype = false, immediate = true, label = "Event heading End Date Chnange Listner",
            description="This component will listen to change in event end date node")
    @Property(name = "event.topics", value="AddNodeListener Event")
    public class AddNodeListener  implements EventListener {
        private Logger log = LoggerFactory.getLogger(AddNodeListener.class);
        @Reference
        private ResourceResolverFactory resolverFactory;
        @Reference
        private SlingRepository repository;
        private Session session;
        private ObservationManager obsMgnr;

        @Activate
        protected void activate(ComponentContext ctxt)
        {
            log.info("##In activate() ##");
            try {
              //  ResourceResolver resolver = resolverFactory.getAdministrativeResourceResolver(null);
              //  Session sessObj = resolver.;
                session = repository.loginAdministrative(null);
                log.info("sessObj is live?"+session.isLive());
                obsMgnr = session.getWorkspace().getObservationManager();
                String[] types={"cq:Page"};
                String[] types1={"dam:Asset"};
                obsMgnr.addEventListener(this,Event.NODE_ADDED | Event.NODE_MOVED, "/content/dam",true, null, types1, false);
                obsMgnr.addEventListener(this, Event.NODE_ADDED,"/content/geometrixx",true,null,types,false);

            }  catch(RepositoryException re){
                re.printStackTrace();

            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }

        /*@Deactivate
         * protected void deactivate(ComponentContext cCtxt)
        {
            log.info("##In deactivate() ##");
            if(obsMgnr !=null)
            {
                try {
                    obsMgnr.removeEventListener(this);
                } catch (RepositoryException e) {
                    // .0
                    TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(session !=null)
            {
                session.logout();
                session=null;
            }
        }*/
        public void onEvent(EventIterator arg0) {
            // TODO Auto-generated method stub
            log.info("## In onEvent() ##");
            long eventsSize = arg0.getSize();
            log.info("eventsSize :"+eventsSize);
            Node nodeObj = null;
            while(arg0.hasNext())
            {
                try {
                    session = repository.loginAdministrative(null);
                    Event event = arg0.nextEvent();
                    String eventFiredPath = event.getPath();
                    log.info("eventFiredPath :"+eventFiredPath);
                    nodeObj = session.getNode(eventFiredPath);
                    log.info("nodeObj is locked ?"+nodeObj.isLocked());
                    session.logout();
                } catch (RepositoryException e) {
                    e.printStackTrace();
                }

            }

        }

    /*public void run() {
        // TODO Auto-generated method stub
        log.info("## In run() ##");
    }
*/


}
