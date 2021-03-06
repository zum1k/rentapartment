package com.training.rentapartment.model.repository.specification.queryparameters;

import com.training.rentapartment.model.repository.SqlQueryParameter;

public class IntegerSqlQueryParameter implements SqlQueryParameter<Integer> {
    public static final String TYPE = "INT";
    private int value;

    public IntegerSqlQueryParameter(int value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String getType() {
        return TYPE;
    }
}
