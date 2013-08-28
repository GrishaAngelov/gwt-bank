package com.clouway.gwtbank.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class DepositPlace extends Place {
    private String depositPlace;

    public DepositPlace(String depositPlace) {
        this.depositPlace = depositPlace;
    }

    public String getDepositPlace() {
        return depositPlace;
    }

    public static class Tokenizer implements PlaceTokenizer<DepositPlace> {

        public DepositPlace getPlace(String s) {
            return new DepositPlace(s);
        }

        public String getToken(DepositPlace depositPlace) {
            return depositPlace.getDepositPlace();
        }
    }
}
