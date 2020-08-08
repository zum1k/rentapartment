package com.training.rentapartment.controller.mapper;

import com.training.rentapartment.controller.EntityMapper;
import com.training.rentapartment.controller.HttpRequestParameters;
import com.training.rentapartment.controller.SessionAttribute;
import com.training.rentapartment.entity.Advertisement;
import com.training.rentapartment.entity.OwnerType;
import com.training.rentapartment.model.SqlConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AdvertisementMapper implements EntityMapper<Advertisement> {
    @Override
    public Advertisement toEntity(HttpServletRequest request) {
        int cost = Integer.parseInt(request.getParameter(HttpRequestParameters.COST_PARAMETER));
        int rooms = Integer.parseInt(request.getParameter(HttpRequestParameters.ROOMS_PARAMETER));
        int floor = Integer.parseInt(request.getParameter(HttpRequestParameters.FLOOR_PARAMETER));
        double square = Double.parseDouble(request.getParameter(HttpRequestParameters.SQUARE_PARAMETER));
        double livingSquare = Double.parseDouble(request.getParameter(HttpRequestParameters.LIVING_SQUARE_PARAMETER));
        double kitchenSquare = Double.parseDouble(request.getParameter(HttpRequestParameters.KITCHEN_SQUARE_PARAMETER));
        OwnerType owner = OwnerType.valueOf(request.getParameter(HttpRequestParameters.OWNER_PARAMETER));
        String phone = request.getParameter(HttpRequestParameters.PHONE_PARAMETER);
        String adDate = request.getParameter(HttpRequestParameters.DATE_PARAMETER);
        int userID = (Integer) request.getSession().getAttribute(SessionAttribute.USER_ID_ATTRIBUTE);
        String description = request.getParameter(HttpRequestParameters.DESCRIPTION_PARAMETER);
        Advertisement advertisement = new Advertisement(cost, rooms, floor, square, livingSquare,
                kitchenSquare, owner, phone, adDate, userID, description);
        return advertisement;
    }
}
