package com.training.rentapartment.model.specification.address;

import com.training.rentapartment.model.Specification;
import com.training.rentapartment.model.SqlConstant;
import com.training.rentapartment.model.SqlQueryParameter;
import com.training.rentapartment.model.specification.queryparameters.StringSqlQueryParameter;

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
