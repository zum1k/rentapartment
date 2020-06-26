package com.epam.training.rentapartment.repository;

import com.epam.training.rentapartment.specification.Specification;

import java.util.Comparator;
import java.util.List;

public interface Repository<T> {
    void add(T t);

    void remove(T t);

    void update(T t);

    List<T> findAll();

    List<T> sort(Comparator<T> comparator);

    List<T> query(Specification specification);
}
