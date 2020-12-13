package com.sn.lde.ngy.converter;

import java.beans.PropertyEditorSupport;
import com.sn.lde.ngy.model.Types;

public class TypesConverter extends PropertyEditorSupport {

    public void setAsText(final String text) throws IllegalArgumentException {
        setValue(Types.fromValue(text));
    }
}
