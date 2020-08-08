package com.training.rentapartment.model.specification.address;

import com.training.rentapartment.model.Specification;
import com.training.rentapartment.model.SqlConstant;
import com.training.rentapartment.model.SqlQueryParameter;
import com.training.rentapartment.model.specification.queryparameters.StringSqlQueryParameter;

import java.util.Arrays;
import java.util.List;

public class AddressByCitySpecification implements Specification {
    private final StringSqlQueryParameter city;

    public AddressByCitySpecification(String city) {
        this.city =  new StringSqlQueryParameter(city);
    }

    @Override
    public String toSqlRequest() {
        return " WHERE " + SqlConstant.ADDRESS_CITY + " = ? ";
    }

    @Override
    public List<SqlQueryParameter> receiveParameters() {
        return Arrays.asList(city);
    }
}
