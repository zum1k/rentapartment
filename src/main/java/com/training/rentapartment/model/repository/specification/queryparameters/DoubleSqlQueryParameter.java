package com.training.rentapartment.model.repository.specification.queryparameters;

import com.training.rentapartment.model.repository.SqlQueryParameter;

public class DoubleSqlQueryParameter implements SqlQueryParameter<Double> {
    public static final String TYPE = "DOUBLE";
    private double value;

    public DoubleSqlQueryParameter(double value) {
        this.value = value;
    }

    @Override
    public Double getValue() {
        return value;
    }

    @Override
    public String getType() {
        return TYPE;
    }
}
