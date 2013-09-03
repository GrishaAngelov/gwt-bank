package com.clouway.gwtbank.client.register;

import com.clouway.gwtbank.client.register.RegisterView.Presenter;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class RegisterActivity extends AbstractActivity {
    private RegisterView registerView;
    private Presenter registerPresenter;

    public RegisterActivity(RegisterView registerView, Presenter registerPresenter) {
        this.registerView = registerView;
        this.registerPresenter = registerPresenter;
    }

    @Override
    public void start(AcceptsOneWidget container, EventBus eventBus) {
        container.setWidget(registerView.asWidget());
        registerView.setPresenter(registerPresenter);
    }
}
