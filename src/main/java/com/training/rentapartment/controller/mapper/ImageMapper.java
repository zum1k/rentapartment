package com.training.rentapartment.controller.mapper;

import com.training.rentapartment.controller.EntityMapper;
import com.training.rentapartment.entity.Image;

import javax.servlet.http.HttpServletRequest;

public class ImageMapper implements EntityMapper<Image> {
    @Override
    public Image toEntity(HttpServletRequest request) {
        return null;
    }
}
