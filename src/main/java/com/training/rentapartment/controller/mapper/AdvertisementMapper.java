package com.training.rentapartment.controller.mapper;

import com.training.rentapartment.controller.EntityMapper;
import com.training.rentapartment.controller.command.SessionAttribute;
import com.training.rentapartment.entity.Advertisement;
import com.training.rentapartment.entity.OwnerType;
import com.training.rentapartment.model.SqlConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AdvertisementMapper implements EntityMapper<Advertisement> {
    @Override
    public Advertisement toEntity(HttpServletRequest request) { //TODO
        HttpSession session = request.getSession();
        int adId = 1; // TODO
        int cost = Integer.parseInt(request.getParameter(SqlConstant.ADVERTISEMENT_COST));
        int rooms = Integer.parseInt(request.getParameter(SqlConstant.ADVERTISEMENT_ROOMS));
        int floor = Integer.parseInt(request.getParameter(SqlConstant.ADVERTISEMENT_FLOOR));
        double square = Double.parseDouble(request.getParameter(SqlConstant.ADVERTISEMENT_SQUARE));
        double livingSquare = Double.parseDouble(request.getParameter(SqlConstant.ADVERTISEMENT_LIVING_SQUARE));
        double kitchenSquare = Double.parseDouble(request.getParameter(SqlConstant.ADVERTISEMENT_KITCHEN_SQUARE));
        OwnerType owner = OwnerType.valueOf(request.getParameter(SqlConstant.ADVERTISEMENT_OWNER));
        String phone = request.getParameter(SqlConstant.ADVERTISEMENT_PHONE);
        String adDate = request.getParameter(SqlConstant.ADVERTISEMENT_DATE);
        int addressId = Integer.parseInt(request.getParameter(SqlConstant.ADDRESS_ID));
        int userID = (Integer) request.getSession().getAttribute(SessionAttribute.USER_ID_ATTRIBUTE);
        String description = request.getParameter(SqlConstant.ADVERTISEMENT_DESCRIPTION);
        Advertisement advertisement = new Advertisement(adId, cost, rooms, floor, square, livingSquare,
                kitchenSquare, owner, phone, adDate, addressId, userID, description);
        return advertisement;
    }
}
