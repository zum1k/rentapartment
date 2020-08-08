package com.training.rentapartment.model;

import java.util.List;

public interface Specification {
    String toSqlRequest();
    List<SqlQueryParameter> receiveParameters();
}
