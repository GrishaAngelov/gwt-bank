package com.clouway.gwtbank.client.view;

import com.clouway.gwtbank.client.UserRequestFactory;
import com.clouway.gwtbank.client.activity.Presenter;
import com.clouway.gwtbank.client.place.MenuPlace;
import com.clouway.gwtbank.client.proxy.UserProxy;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class LoginView extends Composite implements View {

    interface UserInterfaceBinder extends UiBinder<Widget, LoginView> {
    }

    private static UserInterfaceBinder uiBinder = GWT.create(UserInterfaceBinder.class);
    private Presenter presenter;

    public LoginView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiField
    Label titleLabel;

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @UiField
    Label nameLabel;

    @UiField
    TextBox nameBox;

    @UiField
    Label passLabel;

    @UiField
    PasswordTextBox passBox;

    @UiField
    Button loginButton;

    @UiHandler("loginButton")
    void onLoginButtonClick(ClickEvent event) {
        UserRequestFactory factory = GWT.create(UserRequestFactory.class);
        factory.initialize(new SimpleEventBus());
        UserRequestFactory.UserRequestContext context  = factory.context();
        UserProxy userProxy = context.create(UserProxy.class);
//        userProxy.setId(1L);
        userProxy.setUsername(nameBox.getText());
        userProxy.setPassword(passBox.getText());
        context.hasUser(userProxy).fire(new Receiver<Boolean>() {
            @Override
            public void onSuccess(Boolean result) {
                if(result){
                presenter.goToPlace(new MenuPlace("Menu"));
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
