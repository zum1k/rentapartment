package com.training.rentapartment.model.specification.address;

import com.training.rentapartment.model.Specification;
import com.training.rentapartment.model.SqlConstant;
import com.training.rentapartment.model.SqlQueryParameter;
import com.training.rentapartment.model.specification.queryparameters.IntegerSqlQueryParameter;

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
