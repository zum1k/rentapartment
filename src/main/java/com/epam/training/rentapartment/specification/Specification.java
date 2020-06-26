package com.epam.training.rentapartment.specification;

public interface Specification<T> {
    boolean isSpecified(T t);
}
