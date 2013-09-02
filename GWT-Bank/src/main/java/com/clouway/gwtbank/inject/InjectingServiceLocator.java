package com.clouway.gwtbank.inject;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.web.bindery.requestfactory.shared.ServiceLocator;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class InjectingServiceLocator implements ServiceLocator {
    private Injector injector;

    @Inject
    public InjectingServiceLocator(Injector injector) {
        this.injector = injector;
    }

    @Override
    public Object getInstance(Class<?> aClass) {
        return injector.getInstance(aClass);
    }
}
