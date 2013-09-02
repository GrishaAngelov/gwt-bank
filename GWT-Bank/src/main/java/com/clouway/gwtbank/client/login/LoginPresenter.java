package com.clouway.gwtbank.client.login;

import com.clouway.gwtbank.client.View.Presenter;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class LoginPresenter implements Presenter {
    private PlaceController placeController;

    public LoginPresenter(PlaceController placeController) {
        this.placeController = placeController;
    }

    @Override
    public void goToPlace(Place place) {
        placeController.goTo(place);
    }
}
