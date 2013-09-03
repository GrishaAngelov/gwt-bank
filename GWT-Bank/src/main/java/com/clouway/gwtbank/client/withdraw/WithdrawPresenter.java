package com.clouway.gwtbank.client.withdraw;


import com.clouway.gwtbank.client.withdraw.WithdrawView.Presenter;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class WithdrawPresenter implements Presenter {
    private PlaceController placeController;

    public WithdrawPresenter(PlaceController placeController) {
        this.placeController = placeController;
    }

    @Override
    public void goToPlace(Place place) {
        placeController.goTo(place);
    }
}
