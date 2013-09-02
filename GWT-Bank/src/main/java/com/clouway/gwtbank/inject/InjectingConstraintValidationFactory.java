package com.clouway.gwtbank.inject;

import com.google.inject.Inject;
import com.google.inject.Injector;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorFactory;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class InjectingConstraintValidationFactory implements ConstraintValidatorFactory{
    private final Injector injector;

    @Inject
    public InjectingConstraintValidationFactory(Injector injector) {
        this.injector = injector;
    }

    @Override
    public <T extends ConstraintValidator<?, ?>> T getInstance(Class<T> key) {
        return injector.getInstance(key);
    }
}
