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
public class DepositView extends Composite implements View {

    interface MyUiBinder extends UiBinder<Widget, DepositView> {
    }

    private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);
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
