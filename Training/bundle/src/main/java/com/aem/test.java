package com.aem;

import org.apache.jackrabbit.commons.JcrUtils;

import javax.jcr.Node;
import javax.jcr.Repository;
import javax.jcr.SimpleCredentials;

/**
 * Created by vivek on 8/2/15.
 */
public class test {
    public static void main(String a[])
    {
        try {
            Repository repo = JcrUtils.getRepository("http://localhost:8588/crx/server");
           // logger.info("repo"+repo);
            javax.jcr.Session session = repo.login(new SimpleCredentials("admin", "admin".toCharArray()));
         //   logger.info("session"+session);

            Node rootNode = session.getRootNode();
         //   logger.info("Hello "+rootNode.getPath());
            session.logout();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
