package com.clouway.gwtbank.inject;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.web.bindery.requestfactory.server.DefaultExceptionHandler;
import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
@Singleton
public class InjectingRequestFactoryServlet extends RequestFactoryServlet {

    @Inject
    public InjectingRequestFactoryServlet(InjectingServiceLayerDecorator serviceLayerDecorator) {
        super(new DefaultExceptionHandler(), serviceLayerDecorator);
    }
}
