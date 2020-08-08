package com.training.rentapartment.model;

public interface SqlQueryParameter<T> {
    T getValue();
    String getType();
}
