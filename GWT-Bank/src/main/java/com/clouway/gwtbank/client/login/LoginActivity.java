package com.clouway.gwtbank.client.login;

import com.clouway.gwtbank.client.login.LoginView.Presenter;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class LoginActivity extends AbstractActivity {
    private LoginView loginView;
    private Presenter loginPresenter;

    public LoginActivity(LoginView loginView, Presenter loginPresenter) {
        this.loginView = loginView;
        this.loginPresenter = loginPresenter;
    }

    @Override
    public void start(AcceptsOneWidget container, EventBus eventBus) {
        container.setWidget(loginView.asWidget());
        loginView.setPresenter(loginPresenter);
    }
}
