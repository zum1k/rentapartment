package com.training.rentapartment.controller.mapper;

import com.training.rentapartment.controller.EntityMapper;
import com.training.rentapartment.entity.Address;
import com.training.rentapartment.model.SqlConstant;

import javax.servlet.http.HttpServletRequest;

public class AddressMapper implements EntityMapper<Address> {
    @Override
    public Address toEntity(HttpServletRequest request) {
        int addressId = Integer.parseInt(request.getParameter(SqlConstant.ADDRESS_ID));
        String city = request.getParameter(SqlConstant.ADDRESS_CITY);
        String street = request.getParameter(SqlConstant.ADDRESS_STREET);
        int houseNumber = Integer.parseInt(request.getParameter(SqlConstant.ADDRESS_HOUSE_NUMBER));
        int houseIndex = Integer.parseInt(request.getParameter(SqlConstant.ADDRESS_HOUSE_INDEX));
        Address address = new Address(addressId,city, street,houseNumber, houseIndex);
        return address;
    }
}
