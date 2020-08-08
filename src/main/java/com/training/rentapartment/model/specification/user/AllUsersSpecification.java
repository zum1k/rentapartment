package com.training.rentapartment.model.specification.user;

import com.training.rentapartment.model.Specification;
import com.training.rentapartment.model.SqlQueryParameter;

import java.util.Collections;
import java.util.List;

public class AllUsersSpecification implements Specification {
    @Override
    public String toSqlRequest() {
        return ";";
    }

    @Override
    public List<SqlQueryParameter> receiveParameters() {
        return Collections.emptyList();
    }
}
