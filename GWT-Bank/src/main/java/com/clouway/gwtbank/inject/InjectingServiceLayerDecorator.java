package com.clouway.gwtbank.inject;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.web.bindery.requestfactory.server.ServiceLayerDecorator;
import com.google.web.bindery.requestfactory.shared.Locator;
import com.google.web.bindery.requestfactory.shared.RequestContext;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class InjectingServiceLayerDecorator extends ServiceLayerDecorator {
//    private Validator validator;
    private Injector injector;

    @Inject
    public InjectingServiceLayerDecorator(Injector injector) {
//        this.validator = validator;
        this.injector = injector;
    }

    @Override
    public <T extends Locator<?, ?>> T createLocator(Class<T> clazz) {
        return injector.getInstance(clazz);
    }

    @Override
    public Object createServiceInstance(Class<? extends RequestContext> requestContext) {
        return injector.getInstance(resolveServiceClass(requestContext));
    }

//    @Override
//    public <T> Set<ConstraintViolation<T>> validate(T domainObject) {
//        return validator.validate(domainObject);
//    }
}
