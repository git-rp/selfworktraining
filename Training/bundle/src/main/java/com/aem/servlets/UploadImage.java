package com.aem.servlets;

/**
 * Created by intelligrape on 14/3/15.
 */

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.jcr.api.SlingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Binary;
import javax.jcr.Node;
import javax.jcr.Session;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import com.day.cq.dam.api.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;

@SlingServlet(
        description = "upload image",
        paths = "/bin/wem/uploadimage",
        generateComponent = true,
        metatype = true,
        label = "upload image fron html to dam"
)
public class UploadImage extends SlingAllMethodsServlet {
    private static final Logger logger = LoggerFactory.getLogger(UploadImage.class);
    @Reference
    private SlingRepository repository;

    public void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        String image_path = request.getParameter("imagepath");
        logger.info("Image to upload :: " + image_path);
        String pathimg = image_path.substring(image_path.lastIndexOf("\\")+1);
        try {
            Session session = repository.loginAdministrative(null);
            File file = new File("/home/intelligrape/Pictures/"+pathimg);
            FileInputStream is = new FileInputStream(file);
            AssetManager assetManager = request.getResourceResolver().adaptTo(AssetManager.class);
            Asset asset = assetManager.createAsset("/content/dam/"+image_path, is,"image/jpeg", false);
            logger.info(asset.getPath());
            session.save();

            response.setContentType("text/plain");
            response.getWriter().write("Image uploaded");
        }
        catch (Exception e){
            logger.error(e.getMessage());
    }


    }
}