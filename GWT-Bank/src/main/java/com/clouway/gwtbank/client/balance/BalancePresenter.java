package com.clouway.gwtbank.client.balance;

import com.clouway.gwtbank.client.balance.BalanceView.Presenter;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class BalancePresenter implements Presenter {
    private PlaceController placeController;

    public BalancePresenter(PlaceController placeController) {
        this.placeController = placeController;
    }

    @Override
    public void goToPlace(Place place) {
        placeController.goTo(place);
    }
}
