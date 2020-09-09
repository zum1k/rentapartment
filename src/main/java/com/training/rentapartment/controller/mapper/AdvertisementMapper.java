package com.training.rentapartment.controller.mapper;

import com.training.rentapartment.controller.EntityMapper;
import com.training.rentapartment.controller.HttpRequestParameters;
import com.training.rentapartment.controller.SessionAttribute;
import com.training.rentapartment.entity.Advertisement;
import com.training.rentapartment.entity.OwnerType;
import com.training.rentapartment.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public class AdvertisementMapper implements EntityMapper<Advertisement> {
    @Override
    public Advertisement toEntity(HttpServletRequest request) {
        int cost = Integer.parseInt(request.getParameter(HttpRequestParameters.COST));
        int rooms = Integer.parseInt(request.getParameter(HttpRequestParameters.ROOMS));
        int floor = Integer.parseInt(request.getParameter(HttpRequestParameters.FLOOR));
        double square = Double.parseDouble(request.getParameter(HttpRequestParameters.SQUARE));
        double livingSquare = Double.parseDouble(request.getParameter(HttpRequestParameters.LIVING_SQUARE));
        double kitchenSquare = Double.parseDouble(request.getParameter(HttpRequestParameters.KITCHEN_SQUARE));
        OwnerType owner = OwnerType.valueOf(request.getParameter(HttpRequestParameters.OWNER));
        String phone = request.getParameter(HttpRequestParameters.PHONE);
        int userId = Integer.parseInt(request.getParameter(HttpRequestParameters.USER_ID));
        String description = request.getParameter(HttpRequestParameters.DESCRIPTION);
        Advertisement advertisement = new Advertisement(cost, rooms, floor, square, livingSquare,
                kitchenSquare, owner, phone, userId, description);
        return advertisement;
    }

    @Override
    public List<Advertisement> toEntityList(HttpServletRequest request) throws IOException, ServletException {
        return null;
    }
}
