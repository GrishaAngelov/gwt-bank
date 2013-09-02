package com.clouway.gwtbank.client.deposit;

import com.clouway.gwtbank.client.Presenter;
import com.clouway.gwtbank.client.View;
import com.clouway.gwtbank.client.menu.MenuPlace;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class DepositView extends Composite implements View {

    interface UserInterfaceBinder extends UiBinder<Widget, DepositView> {
    }

    private static UserInterfaceBinder uiBinder = GWT.create(UserInterfaceBinder.class);
    private Presenter presenter;

    public DepositView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @UiField
    Label titleLabel;

    @UiField
    TextBox depositBox;

    @UiField
    Button depositButton;

    @UiField
    Anchor goBackLink;

    @UiHandler("depositButton")
    void onDepositClick(ClickEvent event){

    }

    @UiHandler("goBackLink")
    void onGoBackClick(ClickEvent event){
        presenter.goToPlace(new MenuPlace("Menu"));
    }
}
