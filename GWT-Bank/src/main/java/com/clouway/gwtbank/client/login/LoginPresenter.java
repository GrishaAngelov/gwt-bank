package com.clouway.gwtbank.client.login;

import com.clouway.gwtbank.client.login.LoginView.Presenter;
import com.clouway.gwtbank.client.menu.MenuPlace;
import com.clouway.gwtbank.shared.BankRequestFactory;
import com.clouway.gwtbank.shared.UserProxy;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Window;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class LoginPresenter implements Presenter {
    private PlaceController placeController;

    public LoginPresenter(PlaceController placeController) {
        this.placeController = placeController;
    }

    @Override
    public void goToPlace(Place place) {
        placeController.goTo(place);
    }

    @Override
    public void login(String username,String password) {
        BankRequestFactory factory = GWT.create(BankRequestFactory.class);
        factory.initialize(new SimpleEventBus());
        BankRequestFactory.UserRequestContext context  = factory.context();
        UserProxy userProxy = context.create(UserProxy.class);
        userProxy.setUsername(username);
        userProxy.setPassword(password);
        context.hasUser(userProxy).fire(new Receiver<Boolean>() {
            @Override
            public void onSuccess(Boolean result) {
                if(result){
                    placeController.goTo(new MenuPlace("Menu"));
                }else{
                    Window.alert("Incorrect username and/or password");
                }
            }

            @Override
            public void onFailure(ServerFailure error) {
                Window.alert("Incorrect username and/or password");
            }
        });
    }
}
