package com.training.rentapartment.model.repository;

public interface SqlQueryParameter<T> {
    T getValue();
    String getType();
}
