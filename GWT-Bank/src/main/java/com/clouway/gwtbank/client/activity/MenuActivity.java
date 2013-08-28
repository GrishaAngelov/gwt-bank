package com.clouway.gwtbank.client.activity;

import com.clouway.gwtbank.client.view.MenuView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class MenuActivity extends AbstractActivity implements Presenter {
    private MenuView menuView;
    private PlaceController placeController;

    public MenuActivity(MenuView menuView, PlaceController placeController) {
        this.menuView = menuView;
        this.placeController = placeController;
    }

    @Override
    public void start(AcceptsOneWidget container, EventBus eventBus) {
        container.setWidget(menuView.asWidget());
        menuView.setPresenter(this);
    }

    @Override
    public void goToPlace(Place place) {
        placeController.goTo(place);
    }

}
