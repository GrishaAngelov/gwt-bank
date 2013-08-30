package com.clouway.gwtbank.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class WithdrawPlace extends Place {
    private String withdrawPlace;

    public WithdrawPlace(String withdrawPlace) {
        this.withdrawPlace = withdrawPlace;
    }

    public String getWithdrawPlace() {
        return withdrawPlace;
    }

    public static class Tokenizer implements PlaceTokenizer<WithdrawPlace> {

        public WithdrawPlace getPlace(String s) {
            return new WithdrawPlace(s);
        }

        public String getToken(WithdrawPlace withdrawPlace) {
            return withdrawPlace.getWithdrawPlace();
        }
    }
}
