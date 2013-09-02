package com.clouway.gwtbank.client.withdraw;

import com.clouway.gwtbank.client.View.Presenter;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class WithdrawActivity extends AbstractActivity {
    private Presenter withdrawPresenter;
    private WithdrawView withdrawView;

    public WithdrawActivity(WithdrawView withdrawView, Presenter withdrawPresenter) {
        this.withdrawView = withdrawView;
        this.withdrawPresenter = withdrawPresenter;
    }

    @Override
    public void start(AcceptsOneWidget container, EventBus eventBus) {
        container.setWidget(withdrawView.asWidget());
        withdrawView.setPresenter(withdrawPresenter);
    }
}
