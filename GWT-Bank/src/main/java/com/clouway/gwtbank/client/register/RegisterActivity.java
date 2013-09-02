package com.clouway.gwtbank.client.register;

import com.clouway.gwtbank.client.Presenter;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class RegisterActivity extends AbstractActivity implements Presenter {
    private RegisterView registerView;
    private PlaceController placeController;

    public RegisterActivity(RegisterView registerView, PlaceController placeController) {
        this.registerView = registerView;
        this.placeController = placeController;
    }

    @Override
    public void start(AcceptsOneWidget container, EventBus eventBus) {
        container.setWidget(registerView.asWidget());
        registerView.setPresenter(this);
    }

    @Override
    public void goToPlace(Place place) {
        placeController.goTo(place);
    }
}
