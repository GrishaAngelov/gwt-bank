package com.clouway.gwtbank.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class NotStartWithDigitValidator implements ConstraintValidator<CheckNotStartWithDigit,String> {
    private CheckNotStartWithDigit constraint;
    @Override
    public void initialize(CheckNotStartWithDigit constraint) {
        this.constraint = constraint;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !Character.isDigit(value.charAt(0));
    }
}
