package com.training.rentapartment.model.repository;

import java.util.List;

public interface Specification {
    String toSqlRequest();
    List<SqlQueryParameter> receiveParameters();
}
