package com.clouway.gwtbank.client.view;

import com.clouway.gwtbank.client.activity.Presenter;
import com.clouway.gwtbank.client.place.MenuPlace;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class WithdrawView extends Composite implements View {

    interface UserInterfaceBinder extends UiBinder<Widget, WithdrawView> {
    }

    private static UserInterfaceBinder uiBinder = GWT.create(UserInterfaceBinder.class);
    private Presenter presenter;

    public WithdrawView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @UiField
    Label titleLabel;

    @UiField
    TextBox withdrawBox;

    @UiField
    Button withdrawButton;

    @UiField
    Anchor goBackLink;

    @UiHandler("withdrawButton")
    void onDepositClick(ClickEvent event){

    }

    @UiHandler("goBackLink")
    void onGoBackClick(ClickEvent event){
        presenter.goToPlace(new MenuPlace("Menu"));
    }
}
