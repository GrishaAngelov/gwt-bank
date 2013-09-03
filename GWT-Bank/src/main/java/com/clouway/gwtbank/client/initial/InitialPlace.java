package com.clouway.gwtbank.client.initial;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class InitialPlace extends Place {

    private String indexPlace;

    public InitialPlace(String indexPlace) {
        this.indexPlace = indexPlace;
    }

    public String getIndexPlace() {
        return indexPlace;
    }

    public static class Tokenizer implements PlaceTokenizer<InitialPlace> {

        public InitialPlace getPlace(String s) {
            return new InitialPlace(s);
        }

        public String getToken(InitialPlace initialPlace) {
            return initialPlace.getIndexPlace();
        }
    }
}
