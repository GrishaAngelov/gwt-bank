package com.clouway.gwtbank.client.register;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class RegisterPlace extends Place {
    private String registerPlace;

    public RegisterPlace(String registerPlace) {
        this.registerPlace = registerPlace;
    }

    public String getRegisterPlace() {
        return registerPlace;
    }

    public static class Tokenizer implements PlaceTokenizer<RegisterPlace>{

        public RegisterPlace getPlace(String s) {
            return new RegisterPlace(s);
        }

        public String getToken(RegisterPlace loginPlace) {
            return loginPlace.getRegisterPlace();
        }
    }
}
