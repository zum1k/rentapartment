package com.training.rentapartment.model.repository;

import java.util.List;

/**
 * This interface defines the conditions of {@code Repository} interactions with database
 */

public interface Specification {
    /**
     * @return sql query with (?) character instead of actual parameters
     */
    String toSqlRequest();

    /**
     * @return list of all parameters that should participate in the query
     */
    List<SqlQueryParameter> receiveParameters();
}
