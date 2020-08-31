package com.training.rentapartment.controller.mapper;

import com.training.rentapartment.controller.EntityMapper;
import com.training.rentapartment.controller.HttpRequestParameters;
import com.training.rentapartment.entity.Address;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public class AddressMapper implements EntityMapper<Address> {
    @Override
    public Address toEntity(HttpServletRequest request) {
        String city = request.getParameter(HttpRequestParameters.CITY);
        String street = request.getParameter(HttpRequestParameters.STREET);
        int houseNumber = Integer.parseInt(request.getParameter(HttpRequestParameters.HOUSE_NUMBER));
        int houseIndex = Integer.parseInt(request.getParameter(HttpRequestParameters.HOUSE_INDEX));
        Address address = new Address(city, street,houseNumber, houseIndex);
        return address;
    }

    @Override
    public List<Address> toEntityList(HttpServletRequest request) throws IOException, ServletException {
        return null;
    }
}
