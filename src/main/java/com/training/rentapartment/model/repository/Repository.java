package com.training.rentapartment.model.repository;

import com.training.rentapartment.exception.RepositoryException;

import java.util.List;
import java.util.Optional;

/**
 * This interface is built on Repository pattern and it's medium level between database and service logic
 *
 * @param <T> the type of objects with which implementation operates.
 */

public interface Repository<T> extends AutoCloseable {
    /**
     * @param t T
     * @return primary key of last entry
     * @throws RepositoryException if some unforeseen circumstances arose in the code
     */
    int add(T t) throws RepositoryException;

    /**
     * @param specification Specification
     * @throws RepositoryException if some unforeseen circumstances arose in the code
     */
    void remove(Specification specification) throws RepositoryException;

    /**
     * @param specification Specification
     * @return List<T> depending on the specification
     * @throws RepositoryException if some unforeseen circumstances arose in the code
     */
    List<T> query(Specification specification) throws RepositoryException;

    /**
     * @param specification Specification
     * @return <T> depending on the specification
     * @throws RepositoryException if some unforeseen circumstances arose in the code
     */

    Optional<T> singleQuery(Specification specification) throws RepositoryException;
}
