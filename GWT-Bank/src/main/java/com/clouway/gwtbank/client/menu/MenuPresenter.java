package com.clouway.gwtbank.client.menu;

import com.clouway.gwtbank.client.View.Presenter;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;

/**
* @author Grisha Angelov <grisha.angelov@clouway.com>
*/
public class MenuPresenter implements Presenter {
    private PlaceController placeController;

    public MenuPresenter(PlaceController placeController) {
        this.placeController = placeController;
    }

    @Override
    public void goToPlace(Place place) {
        placeController.goTo(place);
    }
}
