package com.clouway.gwtbank.client.deposit;

import com.clouway.gwtbank.client.View.Presenter;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class DepositActivity extends AbstractActivity {
    private DepositView depositView;
    private Presenter depositPresenter;

    public DepositActivity(DepositView depositView, Presenter depositPresenter) {
        this.depositView = depositView;
        this.depositPresenter = depositPresenter;
    }

    @Override
    public void start(AcceptsOneWidget container, EventBus eventBus) {
        container.setWidget(depositView.asWidget());
        depositView.setPresenter(depositPresenter);
    }
}
