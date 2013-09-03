package com.clouway.gwtbank.inject;

import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Provides;
import com.google.inject.servlet.ServletModule;

import javax.inject.Singleton;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class RequestFactoryInjectingModule extends AbstractModule {
    private String url;

    public RequestFactoryInjectingModule(String url) {
        this.url = url;
    }

    @Override
    protected void configure() {
        install(new ServletModule() {
            @Override
            protected void configureServlets() {
                serve(url).with(InjectingRequestFactoryServlet.class);
            }
        });
    }

    @Provides
    @Singleton
    public ValidatorFactory getValidatorFactory(Injector injector) {
        return Validation.byDefaultProvider().configure().constraintValidatorFactory(new InjectingConstraintValidationFactory(injector)).buildValidatorFactory();
    }

    @Provides
    @Singleton
    public Validator getValidator(ValidatorFactory validatorFactory){
        return validatorFactory.getValidator();
    }
}
