package com.training.rentapartment.model.repository.specification.queryparameters;

import com.training.rentapartment.model.repository.SqlQueryParameter;

public class StringSqlQueryParameter implements SqlQueryParameter {
    private final String value;

    public StringSqlQueryParameter(String value) {
        this.value = value;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public String getType() {
        return "STRING";
    }
}
