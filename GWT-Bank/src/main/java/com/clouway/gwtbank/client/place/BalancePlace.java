package com.clouway.gwtbank.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class BalancePlace extends Place {
    private String balancePlace;

    public BalancePlace(String balancePlace) {
        this.balancePlace = balancePlace;
    }

    public String getBalancePlace() {
        return balancePlace;
    }

    public static class Tokenizer implements PlaceTokenizer<BalancePlace>{

        public BalancePlace getPlace(String s) {
            return new BalancePlace(s);
        }

        public String getToken(BalancePlace balancePlace) {
            return balancePlace.getBalancePlace();
        }
    }
}
