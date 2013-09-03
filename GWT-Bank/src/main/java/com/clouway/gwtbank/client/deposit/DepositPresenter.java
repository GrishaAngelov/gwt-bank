package com.clouway.gwtbank.client.deposit;

import com.clouway.gwtbank.client.deposit.DepositView.Presenter;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class DepositPresenter implements Presenter {
    private PlaceController placeController;

    public DepositPresenter(PlaceController placeController) {
        this.placeController = placeController;
    }

    @Override
    public void goToPlace(Place place) {
        placeController.goTo(place);
    }
}
