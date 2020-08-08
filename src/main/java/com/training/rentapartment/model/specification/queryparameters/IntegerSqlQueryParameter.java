package com.training.rentapartment.model.specification.queryparameters;

import com.training.rentapartment.model.SqlQueryParameter;

public class IntegerSqlQueryParameter implements SqlQueryParameter {
    private final int value;

    public IntegerSqlQueryParameter(int value) {
        this.value = value;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public String getType() {
        return "INT";
    }
}
