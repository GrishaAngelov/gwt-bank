package com.clouway.gwtbank.client.initial;

import com.clouway.gwtbank.client.View.Presenter;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class InitialActivity extends AbstractActivity {
    private InitialView initialView;
    private Presenter initialPresenter;


    public InitialActivity(InitialView initialView, Presenter initialPresenter) {
        this.initialView = initialView;
        this.initialPresenter = initialPresenter;
    }

    @Override
    public void start(AcceptsOneWidget container, EventBus eventBus) {
        container.setWidget(initialView.asWidget());
        initialView.setPresenter(initialPresenter);
    }
}
