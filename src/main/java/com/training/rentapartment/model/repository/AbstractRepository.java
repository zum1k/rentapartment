package com.training.rentapartment.model.repository;

import com.training.rentapartment.model.Repository;
import com.training.rentapartment.model.Specification;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public abstract class AbstractRepository<T> implements Repository<T>, Cloneable, AutoCloseable {
    private static final String SELECT_QUERY = "SELECT * FROM ";
    private static final String DELETE_QUERY = "DELETE FROM ";

    private Connection connection;

    public AbstractRepository(Connection connection) {
        this.connection = connection;
    }
    @Override
    public void add(T t) {
    }

    @Override
    public void remove(Specification specification) {
    }

    @Override
    public List<T> query(Specification specification) {
        return null;
    }

    @Override
    public Optional<T> singleQuery(Specification specification) {
        return Optional.empty();
    }

    @Override
    public void close() throws Exception {

    }
}
