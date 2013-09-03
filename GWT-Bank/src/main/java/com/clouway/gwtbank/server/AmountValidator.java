package com.clouway.gwtbank.server;

import java.math.BigDecimal;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public interface AmountValidator {
    boolean validate(BigDecimal amount);
    String checkAmountDelimiter(String amount);
}
