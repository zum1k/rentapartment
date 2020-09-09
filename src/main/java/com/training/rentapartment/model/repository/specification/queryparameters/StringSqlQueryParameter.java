package com.training.rentapartment.model.repository.specification.queryparameters;

import com.training.rentapartment.model.repository.SqlQueryParameter;

public class StringSqlQueryParameter implements SqlQueryParameter<String> {
    public static final String TYPE = "STRING";
    private String value;

    public StringSqlQueryParameter(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getType() {
        return TYPE;
    }
}
