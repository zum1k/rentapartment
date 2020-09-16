package com.training.rentapartment.model.repository;

import com.training.rentapartment.exception.CommandException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * This interface is used for initializing prepared statement parameters and parsing responses from the database
 */

public interface SqlMapper<T> {
    /**
     * *@param resultSet ResultSet
     * @return list of objects depending on the repository type <T>
     * @throws SQLException if some unforeseen circumstances arose in the code
     */
    List<T> toEntity(ResultSet resultSet) throws SQLException;

    /**
     * @param t T
     * @return list of SqlQueryParameters
     */
    Map<String, SqlQueryParameter> toEntityFields(T t);
}
