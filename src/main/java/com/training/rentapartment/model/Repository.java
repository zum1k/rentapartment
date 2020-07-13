package com.training.rentapartment.model;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    void add(T t);

    void remove(Specification specification);

    List<T> query(Specification specification);

    Optional<T> singleQuery(Specification specification);
}
