package com.clouway.gwtbank.client.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.place.shared.Place;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;

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

    private static UserInterfaceBinder uiBinder = GWT.create(UserInterfaceBinder.class);
    private Presenter presenter;

    public LoginView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiField
    Label titleLabel;

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
        presenter.login(nameBox.getText(), passBox.getText());
    }
}
