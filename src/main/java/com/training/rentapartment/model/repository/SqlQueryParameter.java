package com.training.rentapartment.model.repository;

/**
 * this interface defines the type of variable of the classes that inherit the interface specification
 */
public interface SqlQueryParameter<T> {
    /**
     * @return type depending on the parameter type <T>
     */
    T getValue();

    /**
     * @return returns the constant string value of the parameter depending on the parameter <T>
     */
    String getType();
}
