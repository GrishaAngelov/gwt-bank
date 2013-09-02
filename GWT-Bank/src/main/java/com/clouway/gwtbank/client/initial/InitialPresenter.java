package com.clouway.gwtbank.client.initial;

import com.clouway.gwtbank.client.View.Presenter;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class InitialPresenter implements Presenter {
    private PlaceController placeController;

    public InitialPresenter(PlaceController placeController) {
        this.placeController = placeController;
    }

    @Override
    public void goToPlace(Place place) {
        placeController.goTo(place);
    }
}
