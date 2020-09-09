package com.training.rentapartment.model.repository.specification.address;

import com.training.rentapartment.model.repository.Specification;
import com.training.rentapartment.model.repository.SqlConstant;
import com.training.rentapartment.model.repository.SqlQueryParameter;
import com.training.rentapartment.model.repository.specification.queryparameters.IntegerSqlQueryParameter;
import com.training.rentapartment.model.repository.specification.queryparameters.StringSqlQueryParameter;

import java.util.Arrays;
import java.util.List;

public class AddressByAllParametersSpecification implements Specification {
    private final StringSqlQueryParameter city;
    private final StringSqlQueryParameter street;
    private final IntegerSqlQueryParameter houseNumber;
    private final IntegerSqlQueryParameter houseIndex;

    public AddressByAllParametersSpecification(String city, String street, int houseNumber, int houseIndex) {
        this.city = new StringSqlQueryParameter(city);
        this.street = new StringSqlQueryParameter(street);
        this.houseNumber = new IntegerSqlQueryParameter(houseNumber);
        this.houseIndex = new IntegerSqlQueryParameter(houseIndex);
    }

    @Override
    public String toSqlRequest() {
        return " WHERE " + SqlConstant.ADDRESS_CITY + " = ? AND " + SqlConstant.ADDRESS_STREET + " = ? AND " +
                SqlConstant.ADDRESS_HOUSE_NUMBER + " = ? AND " + SqlConstant.ADDRESS_HOUSE_INDEX + " = ? ";
    }

    @Override
    public List<SqlQueryParameter> receiveParameters() {
        return Arrays.asList(city, street, houseNumber, houseIndex);
    }
}
