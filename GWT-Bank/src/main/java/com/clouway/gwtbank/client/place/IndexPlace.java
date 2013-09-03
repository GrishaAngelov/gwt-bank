package com.clouway.gwtbank.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class IndexPlace extends Place {

    private String indexPlace;

    public IndexPlace(String indexPlace) {
        this.indexPlace = indexPlace;
    }

    public String getIndexPlace() {
        return indexPlace;
    }

    public static class Tokenizer implements PlaceTokenizer<IndexPlace> {

        public IndexPlace getPlace(String s) {
            return new IndexPlace(s);
        }

        public String getToken(IndexPlace indexPlace) {
            return indexPlace.getIndexPlace();
        }
    }
}
