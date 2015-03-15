package com.aem.services;

import org.osgi.service.component.ComponentContext;

/**
 * Created by vivek on 21/12/14.
 */
public interface WriteOpService {
    public void writePropToNode(String resourcePath);

}
