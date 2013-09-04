package com.clouway.gwtbank.client.register;

import com.clouway.gwtbank.client.editor.UserEditor;
import com.clouway.gwtbank.shared.BankRequestFactory;
import com.clouway.gwtbank.shared.UserProxy;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.place.shared.Place;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class RegisterView extends Composite {
    public interface Presenter {

        void goToPlace(Place place);

        void register(String username, String password);
    }

    interface UserInterfaceBinder extends UiBinder<Widget, RegisterView> {

    }

    interface Driver extends RequestFactoryEditorDriver<UserProxy, UserEditor> {
    }

    private Driver driver = GWT.create(Driver.class);
    private static UserInterfaceBinder uiBinder = GWT.create(UserInterfaceBinder.class);

    private Presenter presenter;
    private UserProxy userProxy;

    @UiField
    UserEditor userEditor;

    @UiField
    Button registerButton;

    public RegisterView(BankRequestFactory bankRequestFactory) {
        initWidget(uiBinder.createAndBindUi(this));

        driver.initialize(userEditor);

        BankRequestFactory.UserRequestContext userRequestContext = bankRequestFactory.context();

        userProxy = userRequestContext.create(UserProxy.class);

        driver.edit(userProxy, userRequestContext);
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @UiHandler("registerButton")
    void onRegisterButtonClick(ClickEvent event) {
        driver.flush();
        presenter.register(userProxy.getUsername(), userProxy.getPassword());
    }
}
