package com.clouway.gwtbank.client.login;

import com.clouway.gwtbank.client.Presenter;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class LoginActivity extends AbstractActivity implements Presenter {
    private LoginView loginView;
    private PlaceController placeController;

    public LoginActivity(LoginView loginView, PlaceController placeController) {
        this.loginView = loginView;
        this.placeController = placeController;
    }

    @Override
    public void start(AcceptsOneWidget container, EventBus eventBus) {
        container.setWidget(loginView.asWidget());
        loginView.setPresenter(this);
    }

    @Override
    public void goToPlace(Place place) {
        placeController.goTo(place);
    }
}
