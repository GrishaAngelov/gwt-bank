package com.clouway.gwtbank.server;

import com.google.inject.Inject;

import java.math.BigDecimal;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class AmountValueValidator implements AmountValidator {
    private Double limitAmountValue;

    @Inject
    public AmountValueValidator(double limitAmountValue) {
        this.limitAmountValue = limitAmountValue;
    }

    @Override
    public boolean validate(BigDecimal amount) {
        boolean isValid = true;
        if (amount.doubleValue() < 0 || "0".equals(amount.toString()) || amount.doubleValue() > limitAmountValue) {
            throw new IncorrectAmountValueException();
        }
        return isValid;
    }

    @Override
    public String checkAmountDelimiter(String amount) {
        final int offset = 3;
        if (amount.contains(",")) {
            amount = amount.replace(',', '.');
        }
        if (amount.contains(".") && amount.indexOf(".") + offset != amount.length()) {
            amount = amount.concat("0");
        }
        return amount;
    }
}
