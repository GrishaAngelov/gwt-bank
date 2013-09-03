package com.clouway.gwtbank.client;

import com.clouway.gwtbank.client.balance.BalancePlace;
import com.clouway.gwtbank.client.deposit.DepositPlace;
import com.clouway.gwtbank.client.initial.InitialPlace;
import com.clouway.gwtbank.client.login.LoginPlace;
import com.clouway.gwtbank.client.menu.MenuPlace;
import com.clouway.gwtbank.client.register.RegisterPlace;
import com.clouway.gwtbank.client.withdraw.WithdrawPlace;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
@WithTokenizers({LoginPlace.Tokenizer.class, InitialPlace.Tokenizer.class,
        RegisterPlace.Tokenizer.class, MenuPlace.Tokenizer.class, BalancePlace.Tokenizer.class, DepositPlace.Tokenizer.class, WithdrawPlace.Tokenizer.class})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}
