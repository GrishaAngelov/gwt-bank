package com.clouway.gwtbank.client.menu;

import com.clouway.gwtbank.client.menu.MenuView.Presenter;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class MenuActivity extends AbstractActivity {
    private MenuView menuView;
    private Presenter menuPresenter;


    public MenuActivity(MenuView menuView, Presenter menuPresenter) {
        this.menuView = menuView;
        this.menuPresenter = menuPresenter;
    }

    @Override
    public void start(AcceptsOneWidget container, EventBus eventBus) {
        container.setWidget(menuView.asWidget());
        menuView.setPresenter(menuPresenter);
    }
}
