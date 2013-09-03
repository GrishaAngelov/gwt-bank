package com.clouway.gwtbank.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotStartWithDigitValidator.class)
@Documented
public @interface CheckNotStartWithDigit {
    String message() default "{test}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
