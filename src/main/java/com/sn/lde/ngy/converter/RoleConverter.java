package com.sn.lde.ngy.converter;

import java.beans.PropertyEditorSupport;
import com.sn.lde.ngy.model.Role;

public class RoleConverter extends PropertyEditorSupport {

    @Override
    public void setAsText(final String text) {
        setValue(Role.fromValue(text));
    }

}
