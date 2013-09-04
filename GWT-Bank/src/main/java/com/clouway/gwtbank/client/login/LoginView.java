package com.clouway.gwtbank.client.login;

import com.clouway.gwtbank.client.editor.UserEditor;
import com.clouway.gwtbank.shared.BankRequestFactory;
import com.clouway.gwtbank.shared.UserProxy;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.place.shared.Place;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class LoginView extends Composite {
    interface Presenter {
        void goToPlace(Place place);

        void login(String username, String password);
    }

    interface UserInterfaceBinder extends UiBinder<Widget, LoginView> {
    }

    interface Driver extends RequestFactoryEditorDriver<UserProxy, UserEditor> {
    }

    private static UserInterfaceBinder uiBinder = GWT.create(UserInterfaceBinder.class);
    private Presenter presenter;
    private Driver driver = GWT.create(Driver.class);
    private UserProxy userProxy;

    public LoginView(BankRequestFactory bankRequestFactory) {
        initWidget(uiBinder.createAndBindUi(this));
        driver.initialize(userEditor);
        BankRequestFactory.UserRequestContext userRequestContext = bankRequestFactory.context();
        userProxy = userRequestContext.create(UserProxy.class);
        driver.edit(userProxy, userRequestContext);
    }

    @UiField
    Label titleLabel;

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @UiField
    UserEditor userEditor;

    @UiField
    Button loginButton;

    @UiHandler("loginButton")
    void onLoginButtonClick(ClickEvent event) {
        driver.flush();
        presenter.login(userProxy.getUsername(), userProxy.getPassword());
    }
}
