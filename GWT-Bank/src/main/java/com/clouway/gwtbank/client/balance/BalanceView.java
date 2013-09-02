package com.clouway.gwtbank.client.balance;

import com.clouway.gwtbank.client.menu.MenuPlace;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.place.shared.Place;
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
public class BalanceView extends Composite {
    interface Presenter {
        void goToPlace(Place place);
    }

    interface UserInterfaceBinder extends UiBinder<Widget, BalanceView> {
    }

    private static UserInterfaceBinder uiBinder = GWT.create(UserInterfaceBinder.class);
    private Presenter presenter;

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
    void onGoBackLinkClick(ClickEvent event) {
        presenter.goToPlace(new MenuPlace("Menu"));
    }

}
