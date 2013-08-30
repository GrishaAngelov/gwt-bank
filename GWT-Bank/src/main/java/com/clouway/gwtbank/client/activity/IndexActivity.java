package com.clouway.gwtbank.client.activity;

import com.clouway.gwtbank.client.view.IndexView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class IndexActivity extends AbstractActivity implements Presenter {
    private IndexView indexView;
    private PlaceController placeController;

    public IndexActivity(IndexView indexView, PlaceController placeController) {
        this.indexView = indexView;
        this.placeController = placeController;
    }

    @Override
    public void start(AcceptsOneWidget container, EventBus eventBus) {
        container.setWidget(indexView.asWidget());
        indexView.setPresenter(this);
    }

    @Override
    public void goToPlace(Place place) {
        placeController.goTo(place);
    }
}
