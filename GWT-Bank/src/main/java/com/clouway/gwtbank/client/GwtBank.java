package com.clouway.gwtbank.client;

import com.clouway.gwtbank.client.initial.InitialPlace;
import com.clouway.gwtbank.shared.UserRequestFactory;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GwtBank implements EntryPoint {
    private Place defaultPlace = new InitialPlace("Index");
    private SimplePanel simplePanel = new SimplePanel();

    @Override
    public void onModuleLoad() {
        RootPanel.get().getElement().getStyle().setBackgroundColor("#808080");
        EventBus eventBus = new SimpleEventBus();
        PlaceController placeController = new PlaceController(eventBus);

        UserRequestFactory userRequestFactory = GWT.create(UserRequestFactory.class);
        userRequestFactory.initialize(eventBus);

        ActivityMapper activityMapper = new AppActivityMapper(placeController, userRequestFactory);
        ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
        activityManager.setDisplay(simplePanel);

        AppPlaceHistoryMapper placeHistoryMapper = GWT.create(AppPlaceHistoryMapper.class);
        PlaceHistoryHandler placeHistoryHandler = new PlaceHistoryHandler(placeHistoryMapper);
        placeHistoryHandler.register(placeController, eventBus, defaultPlace);

        RootPanel.get().add(simplePanel);
        placeHistoryHandler.handleCurrentHistory();

    }
}
