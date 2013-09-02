package com.clouway.gwtbank.client.login;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class LoginPlace extends Place {
    private String loginPlace;

    public LoginPlace(String loginPlace) {
        this.loginPlace = loginPlace;
    }

    public String getLoginPlace() {
        return loginPlace;
    }

    public static class Tokenizer implements PlaceTokenizer<LoginPlace>{

        public LoginPlace getPlace(String s) {
            return new LoginPlace(s);
        }

        public String getToken(LoginPlace loginPlace) {
            return loginPlace.getLoginPlace();
        }
    }
}
