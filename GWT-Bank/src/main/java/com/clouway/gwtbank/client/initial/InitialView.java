package com.clouway.gwtbank.client.initial;

import com.clouway.gwtbank.client.login.LoginPlace;
import com.clouway.gwtbank.client.register.RegisterPlace;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.place.shared.Place;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class InitialView extends Composite{
    interface Presenter{
        void goToPlace(Place place);
    }
    interface UserInterfaceBinder extends UiBinder<Widget, InitialView> {
    }

    private static UserInterfaceBinder uiBinder = GWT.create(UserInterfaceBinder.class);
    private Presenter presenter;

    public InitialView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @UiField
    Anchor registerLink;

    @UiField
    Anchor loginLink;

    @UiHandler("registerLink")
    void onRegisterClick(ClickEvent event) {
      presenter.goToPlace(new RegisterPlace("Register"));
    }

    @UiHandler("loginLink")
    void onLoginClick(ClickEvent event) {
      presenter.goToPlace(new LoginPlace("Login"));
    }
}
