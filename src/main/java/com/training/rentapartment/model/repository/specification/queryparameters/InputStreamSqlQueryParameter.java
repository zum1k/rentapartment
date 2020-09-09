package com.training.rentapartment.model.repository.specification.queryparameters;

import com.training.rentapartment.model.repository.SqlQueryParameter;

import java.io.InputStream;

public class InputStreamSqlQueryParameter implements SqlQueryParameter<InputStream> {
    public static final String TYPE = "BYTE";
    private final InputStream value;

    public InputStreamSqlQueryParameter(InputStream value) {
        this.value = value;
    }

    @Override
    public InputStream getValue() {
        return value;
    }

    @Override
    public String getType() {
        return TYPE;
    }
}
