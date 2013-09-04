package com.clouway.gwtbank.client.editor;

import com.clouway.gwtbank.shared.UserProxy;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class UserEditor extends Composite implements Editor<UserProxy> {
    interface UserEditorUiBinder extends UiBinder<Widget, UserEditor> {
    }

    private static UserEditorUiBinder uiBinder = GWT.create(UserEditorUiBinder.class);

    public UserEditor() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiField
    @Ignore
    Label nameLabel;

    @UiField
    TextBox username;

    @UiField
    @Ignore
    Label passwordLabel;

    @UiField
    PasswordTextBox password;
}
