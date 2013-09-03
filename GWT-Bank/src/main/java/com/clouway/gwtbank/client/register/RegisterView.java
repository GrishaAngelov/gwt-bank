package com.clouway.gwtbank.client.register;

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
public class RegisterView extends Composite {
    interface Presenter {
        void goToPlace(Place place);
        void register(String username,String password);
    }

    interface UserInterfaceBinder extends UiBinder<Widget, RegisterView> {
    }

    private static UserInterfaceBinder uiBinder = GWT.create(UserInterfaceBinder.class);
    private Presenter presenter;

    public RegisterView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

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
        presenter.register(nameBox.getText(), passBox.getText());
    }

}
