package com.clouway.gwtbank.client.activity;

import com.clouway.gwtbank.client.view.BalanceView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class BalanceActivity extends AbstractActivity implements Presenter {
    private PlaceController placeController;
    private BalanceView balanceView;

    public BalanceActivity(BalanceView balanceView, PlaceController placeController) {
        this.balanceView = balanceView;
        this.placeController = placeController;
    }

    @Override
    public void start(AcceptsOneWidget container, EventBus eventBus) {
        container.setWidget(balanceView.asWidget());
        balanceView.setPresenter(this);
    }

    @Override
    public void goToPlace(Place place) {
        placeController.goTo(place);
    }
}
