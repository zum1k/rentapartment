package com.training.rentapartment.controller.mapper;

import com.training.rentapartment.controller.EntityMapper;
import com.training.rentapartment.controller.HttpRequestParameters;
import com.training.rentapartment.entity.Address;
import com.training.rentapartment.model.SqlConstant;

import javax.servlet.http.HttpServletRequest;

public class AddressMapper implements EntityMapper<Address> {
    @Override
    public Address toEntity(HttpServletRequest request) {
        String city = request.getParameter(HttpRequestParameters.CITY_PARAMETER);
        String street = request.getParameter(HttpRequestParameters.STREET_PARAMETER);
        int houseNumber = Integer.parseInt(request.getParameter(HttpRequestParameters.HOUSE_NUMBER_PARAMETER));
        int houseIndex = Integer.parseInt(request.getParameter(HttpRequestParameters.HOUSE_INDEX_PARAMETER));
        Address address = new Address(city, street,houseNumber, houseIndex);
        return address;
    }
}
