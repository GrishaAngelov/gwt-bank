package com.clouway.gwtbank.client.view;

import com.clouway.gwtbank.client.activity.Presenter;
import com.clouway.gwtbank.client.place.BalancePlace;
import com.clouway.gwtbank.client.place.DepositPlace;
import com.clouway.gwtbank.client.place.WithdrawPlace;
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
public class MenuView extends Composite implements View {

    interface UserInterfaceBinder extends UiBinder<Widget, MenuView> {
    }

    private static UserInterfaceBinder uiBinder = GWT.create(UserInterfaceBinder.class);
    private Presenter presenter;

    public MenuView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @UiField
    Anchor balanceLink;

    @UiField
    Anchor depositLink;

    @UiField
    Anchor withdrawLink;

    @UiHandler("balanceLink")
    void onBalanceClick(ClickEvent event){
        presenter.goToPlace(new BalancePlace("Balance"));
    }

    @UiHandler("depositLink")
    void onDepositClick(ClickEvent event){
        presenter.goToPlace(new DepositPlace("Deposit"));
    }

    @UiHandler("withdrawLink")
    void onWithdrawClick(ClickEvent event){
        presenter.goToPlace(new WithdrawPlace("Withdraw"));
    }
}
