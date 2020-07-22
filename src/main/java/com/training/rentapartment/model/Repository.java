package com.training.rentapartment.model;

import com.training.rentapartment.exception.RepositoryException;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    void add(T t) throws RepositoryException;

    void remove(Specification specification) throws RepositoryException;

    List<T> query(Specification specification) throws RepositoryException;

    Optional<T> singleQuery(Specification specification) throws RepositoryException;
}
