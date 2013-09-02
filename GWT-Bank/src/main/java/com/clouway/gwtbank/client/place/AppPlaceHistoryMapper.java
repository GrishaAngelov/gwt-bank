package com.clouway.gwtbank.client.place;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
@WithTokenizers({LoginPlace.Tokenizer.class, InitialPlace.Tokenizer.class,
        RegisterPlace.Tokenizer.class, MenuPlace.Tokenizer.class, BalancePlace.Tokenizer.class, DepositPlace.Tokenizer.class, WithdrawPlace.Tokenizer.class})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}
