package com.clouway.gwtbank.client.initial;

import com.clouway.gwtbank.client.Presenter;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class InitialActivity extends AbstractActivity implements Presenter {
    private InitialView initialView;
    private PlaceController placeController;

    public InitialActivity(InitialView initialView, PlaceController placeController) {
        this.initialView = initialView;
        this.placeController = placeController;
    }

    @Override
    public void start(AcceptsOneWidget container, EventBus eventBus) {
        container.setWidget(initialView.asWidget());
        initialView.setPresenter(this);
    }

    @Override
    public void goToPlace(Place place) {
        placeController.goTo(place);
    }
}
