package com.training.rentapartment.model.repository.specification.address;

import com.training.rentapartment.model.repository.Specification;
import com.training.rentapartment.model.repository.SqlConstant;
import com.training.rentapartment.model.repository.SqlQueryParameter;
import com.training.rentapartment.model.repository.specification.queryparameters.StringSqlQueryParameter;

import java.util.Arrays;
import java.util.List;

public class AddressByStreetSpecification implements Specification {
    private final StringSqlQueryParameter street;

    public AddressByStreetSpecification(String street) {
        this.street = new StringSqlQueryParameter(street);
    }

    @Override
    public String toSqlRequest() {
        return " WHERE " + SqlConstant.ADDRESS_STREET + " = ? ";
    }

    @Override
    public List<SqlQueryParameter> receiveParameters() {
        return Arrays.asList(street);
    }
}
