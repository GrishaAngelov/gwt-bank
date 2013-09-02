package com.clouway.gwtbank.client.register;

import com.clouway.gwtbank.client.login.LoginPlace;
import com.clouway.gwtbank.shared.UserProxy;
import com.clouway.gwtbank.shared.UserRequestFactory;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Window;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class RegisterPresenter implements RegisterView.Presenter {
    private PlaceController placeController;

    public RegisterPresenter(PlaceController placeController) {
        this.placeController = placeController;
    }

    @Override
    public void goToPlace(Place place) {
        placeController.goTo(place);
    }

    @Override
    public void register(String username, String password) {

        UserRequestFactory.UserRequestContext context = createFactory().context();
        UserProxy userProxy = context.create(UserProxy.class);
        userProxy.setUsername(username);
        userProxy.setPassword(password);

        context.add(userProxy).fire(new Receiver<Boolean>() {
            @Override
            public void onSuccess(Boolean result) {
                placeController.goTo(new LoginPlace("Login"));
            }

            @Override
            public void onFailure(ServerFailure error) {
                Window.alert("Not registered");
            }
        });

    }

    private UserRequestFactory createFactory() {
        UserRequestFactory factory = GWT.create(UserRequestFactory.class);
        factory.initialize(new SimpleEventBus());
        return factory;
    }
}
