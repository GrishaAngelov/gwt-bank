package com.clouway.gwtbank.client.activity;

import com.clouway.gwtbank.client.place.*;
import com.clouway.gwtbank.client.view.*;
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
            return new LoginActivity(new LoginView(), placeController);
        } else if (place instanceof IndexPlace) {
            return new IndexActivity(new IndexView(), placeController);
        } else if (place instanceof RegisterPlace) {
            return new RegisterActivity(new RegisterView(), placeController);
        } else if (place instanceof MenuPlace) {
            return new MenuActivity(new MenuView(), placeController);
        } else if (place instanceof BalancePlace) {
            return new BalanceActivity(new BalanceView(), placeController);
        } else if (place instanceof DepositPlace) {
            return new DepositActivity(new DepositView(), placeController);
        } else if(place instanceof WithdrawPlace){
            return new WithdrawActivity(new WithdrawView(),placeController);
        }
        return null;
    }
}
