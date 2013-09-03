package com.clouway.gwtbank.client;

import com.clouway.gwtbank.client.balance.BalanceActivity;
import com.clouway.gwtbank.client.balance.BalancePlace;
import com.clouway.gwtbank.client.balance.BalancePresenter;
import com.clouway.gwtbank.client.balance.BalanceView;
import com.clouway.gwtbank.client.deposit.DepositActivity;
import com.clouway.gwtbank.client.deposit.DepositPlace;
import com.clouway.gwtbank.client.deposit.DepositPresenter;
import com.clouway.gwtbank.client.deposit.DepositView;
import com.clouway.gwtbank.client.initial.InitialActivity;
import com.clouway.gwtbank.client.initial.InitialPlace;
import com.clouway.gwtbank.client.initial.InitialPresenter;
import com.clouway.gwtbank.client.initial.InitialView;
import com.clouway.gwtbank.client.login.LoginPlace;
import com.clouway.gwtbank.client.login.LoginPresenter;
import com.clouway.gwtbank.client.login.LoginView;
import com.clouway.gwtbank.client.login.LoginActivity;
import com.clouway.gwtbank.client.menu.MenuActivity;
import com.clouway.gwtbank.client.menu.MenuPlace;
import com.clouway.gwtbank.client.menu.MenuPresenter;
import com.clouway.gwtbank.client.menu.MenuView;
import com.clouway.gwtbank.client.register.RegisterActivity;
import com.clouway.gwtbank.client.register.RegisterPlace;
import com.clouway.gwtbank.client.register.RegisterPresenter;
import com.clouway.gwtbank.client.register.RegisterView;
import com.clouway.gwtbank.client.withdraw.WithdrawActivity;
import com.clouway.gwtbank.client.withdraw.WithdrawPlace;
import com.clouway.gwtbank.client.withdraw.WithdrawPresenter;
import com.clouway.gwtbank.client.withdraw.WithdrawView;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class AppActivityMapper implements ActivityMapper {
    private PlaceController placeController;

    public AppActivityMapper(PlaceController placeController) {
        this.placeController = placeController;
    }

    public Activity getActivity(Place place) {
        if (place instanceof LoginPlace) {
            return new LoginActivity(new LoginView(), new LoginPresenter(placeController));
        } else if (place instanceof InitialPlace) {
            return new InitialActivity(new InitialView(), new InitialPresenter(placeController));
        } else if (place instanceof RegisterPlace) {
            return new RegisterActivity(new RegisterView(), new RegisterPresenter(placeController));
        } else if (place instanceof MenuPlace) {
            return new MenuActivity(new MenuView(), new MenuPresenter(placeController));
        } else if (place instanceof BalancePlace) {
            return new BalanceActivity(new BalanceView(), new BalancePresenter(placeController));
        } else if (place instanceof DepositPlace) {
            return new DepositActivity(new DepositView(), new DepositPresenter(placeController));
        } else if (place instanceof WithdrawPlace) {
            return new WithdrawActivity(new WithdrawView(), new WithdrawPresenter(placeController));
        }
        return null;
    }
}
