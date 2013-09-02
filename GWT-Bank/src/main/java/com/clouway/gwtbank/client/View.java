package com.clouway.gwtbank.client;


import com.google.gwt.place.shared.Place;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public interface View {
    public interface Presenter {
        void goToPlace(Place place);
    }

    void setPresenter(Presenter presenter);
}
