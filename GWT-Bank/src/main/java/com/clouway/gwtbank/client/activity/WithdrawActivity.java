package com.clouway.gwtbank.client.activity;

import com.clouway.gwtbank.client.view.DepositView;
import com.clouway.gwtbank.client.view.WithdrawView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class WithdrawActivity extends AbstractActivity implements Presenter {
    private PlaceController placeController;
    private WithdrawView withdrawView;

    public WithdrawActivity(WithdrawView withdrawView, PlaceController placeController) {
        this.withdrawView = withdrawView;
        this.placeController = placeController;
    }

    @Override
    public void start(AcceptsOneWidget container, EventBus eventBus) {
        container.setWidget(withdrawView.asWidget());
        withdrawView.setPresenter(this);
    }

    @Override
    public void goToPlace(Place place) {
        placeController.goTo(place);
    }
}
