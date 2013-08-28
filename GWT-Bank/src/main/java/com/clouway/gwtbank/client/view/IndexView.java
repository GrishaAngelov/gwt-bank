package com.clouway.gwtbank.client.view;

import com.clouway.gwtbank.client.activity.Presenter;
import com.clouway.gwtbank.client.place.LoginPlace;
import com.clouway.gwtbank.client.place.RegisterPlace;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class IndexView extends Composite implements View {
    interface MyUiBinder extends UiBinder<Widget, IndexView> {
    }

    private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);
    private Presenter presenter;

    public IndexView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
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
