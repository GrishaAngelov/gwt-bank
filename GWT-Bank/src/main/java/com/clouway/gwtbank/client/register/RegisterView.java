package com.clouway.gwtbank.client.register;

import com.clouway.gwtbank.client.View;
import com.clouway.gwtbank.shared.UserRequestFactory;
import com.clouway.gwtbank.client.View.Presenter;
import com.clouway.gwtbank.client.login.LoginPlace;
import com.clouway.gwtbank.shared.UserProxy;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class RegisterView extends Composite implements View {

    interface UserInterfaceBinder extends UiBinder<Widget, RegisterView> {
    }

    private static UserInterfaceBinder uiBinder = GWT.create(UserInterfaceBinder.class);
    private Presenter presenter;

    public RegisterView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @UiField
    Label titleLabel;

    @UiField
    Label nameLabel;

    @UiField
    TextBox nameBox;

    @UiField
    Label passLabel;

    @UiField
    PasswordTextBox passBox;

    @UiField
    Button registerButton;

    @UiHandler("registerButton")
    void onRegisterButtonClick(ClickEvent event) {

        UserRequestFactory.UserRequestContext context = createFactory().context();
        UserProxy userProxy = context.create(UserProxy.class);
//        userProxy.setId(1L);
        userProxy.setUsername(nameBox.getText());
        userProxy.setPassword(passBox.getText());

        context.add(userProxy).fire(new Receiver<Boolean>() {
            @Override
            public void onSuccess(Boolean result) {
                presenter.goToPlace(new LoginPlace("Login"));
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
