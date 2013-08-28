package com.clouway.gwtbank.client.view;

import com.clouway.gwtbank.client.activity.Presenter;
import com.clouway.gwtbank.client.place.MenuPlace;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class BalanceView extends Composite implements View {

    interface MyUiBinder extends UiBinder<Widget, BalanceView> {
    }

    private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);
    private Presenter presenter;

    @Override
    public void setPresenter(Presenter presenter) {
       this.presenter = presenter;
    }

    public BalanceView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiField
    Label titleLabel;

    @UiField
    Label balanceLabel;

    @UiField
    Anchor goBackLink;

    @UiHandler("goBackLink")
    void onGoBackLinkClick(ClickEvent event){
        presenter.goToPlace(new MenuPlace("Menu"));
    }

}
