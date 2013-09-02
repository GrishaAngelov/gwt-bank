package com.clouway.gwtbank.client.balance;

import com.clouway.gwtbank.client.balance.BalanceView.Presenter;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class BalanceActivity extends AbstractActivity {
    private BalanceView balanceView;
    private Presenter balancePresenter;

    public BalanceActivity(BalanceView balanceView, Presenter balancePresenter) {
        this.balanceView = balanceView;
        this.balancePresenter = balancePresenter;
    }

    @Override
    public void start(AcceptsOneWidget container, EventBus eventBus) {
        container.setWidget(balanceView.asWidget());
        balanceView.setPresenter(balancePresenter);
    }
}
