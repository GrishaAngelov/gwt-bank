package com.clouway.gwtbank.client.view;

import com.clouway.gwtbank.client.activity.Presenter;
import com.clouway.gwtbank.client.place.RegisterPlace;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class RegisterView extends Composite implements View {

    interface MyUiBinder extends UiBinder<Widget,RegisterView>{}

    private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);
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
    TextBox passBox;

    @UiField
    Button registerButton;

    @UiHandler("registerButton")
    void onLoginButtonClick(ClickEvent event){
       presenter.goToPlace(new RegisterPlace("Register"));
    }
}
