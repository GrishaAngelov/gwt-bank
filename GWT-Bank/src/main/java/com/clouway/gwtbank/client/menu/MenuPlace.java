package com.clouway.gwtbank.client.menu;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class MenuPlace extends Place {
    private String menuPlace;

    public MenuPlace(String menuPlace) {
        this.menuPlace = menuPlace;
    }

    public String getMenuPlace() {
        return menuPlace;
    }

    public static class Tokenizer implements PlaceTokenizer<MenuPlace>{

        public MenuPlace getPlace(String s) {
            return new MenuPlace(s);
        }

        public String getToken(MenuPlace menuPlace) {
            return menuPlace.getMenuPlace();
        }
    }
}
