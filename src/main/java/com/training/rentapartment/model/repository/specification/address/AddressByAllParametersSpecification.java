package com.training.rentapartment.model.repository.specification.address;

import com.training.rentapartment.entity.Address;
import com.training.rentapartment.model.repository.Specification;
import com.training.rentapartment.model.repository.SqlConstant;
import com.training.rentapartment.model.repository.SqlQueryParameter;
import com.training.rentapartment.model.repository.specification.queryparameters.IntegerSqlQueryParameter;
import com.training.rentapartment.model.repository.specification.queryparameters.StringSqlQueryParameter;

import java.util.Arrays;
import java.util.List;

public class AddressByAllParametersSpecification implements Specification {
    private final Address address;

    public AddressByAllParametersSpecification(Address address) {
        this.address = address;
    }

    @Override
    public String toSqlRequest() {
        return " WHERE " + SqlConstant.ADDRESS_CITY + " = ? AND " + SqlConstant.ADDRESS_STREET + " = ? AND " +
                SqlConstant.ADDRESS_HOUSE_NUMBER + " = ? AND " + SqlConstant.ADDRESS_HOUSE_INDEX;
    }

    @Override
    public List<SqlQueryParameter> receiveParameters() {
        StringSqlQueryParameter city = new StringSqlQueryParameter(address.getCity());
        StringSqlQueryParameter street = new StringSqlQueryParameter(address.getStreet());
        IntegerSqlQueryParameter houseNumber = new IntegerSqlQueryParameter(address.getHouseNumber());
        IntegerSqlQueryParameter houseIndex = new IntegerSqlQueryParameter(address.getHouseIndex());
        return Arrays.asList(city, street, houseNumber, houseIndex);
    }
}
