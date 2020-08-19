package com.training.rentapartment.model.repository.specification.address;

import com.training.rentapartment.model.repository.Specification;
import com.training.rentapartment.model.repository.SqlConstant;
import com.training.rentapartment.model.repository.SqlQueryParameter;
import com.training.rentapartment.model.repository.specification.queryparameters.IntegerSqlQueryParameter;

import java.util.Arrays;
import java.util.List;

public class AddressByIdSpecification implements Specification {
    private final IntegerSqlQueryParameter addressId;

    public AddressByIdSpecification(int addressId) {
        this.addressId =  new IntegerSqlQueryParameter(addressId);
    }

    @Override
    public String toSqlRequest() {
        return " WHERE " + SqlConstant.ADDRESS_ID + " = ? ";
    }

    @Override
    public List<SqlQueryParameter> receiveParameters() {
        return Arrays.asList(addressId);
    }
}
