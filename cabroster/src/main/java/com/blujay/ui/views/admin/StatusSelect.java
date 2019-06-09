package com.blujay.ui.views.admin;

import com.blujay.backend.data.Status;
import com.vaadin.ui.ComboBox;

public class StatusSelect extends ComboBox<String> {

    private static final long serialVersionUID = 1L;

    public StatusSelect() {
        setCaption("Status");
        setEmptySelectionAllowed(false);
        setItems(Status.getAllRoles());
        setTextInputAllowed(false);
    }
}
