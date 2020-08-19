package com.training.rentapartment.controller.mapper;

import com.training.rentapartment.controller.EntityMapper;
import com.training.rentapartment.entity.Image;
import com.training.rentapartment.model.repository.SqlConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

public class ImageMapper implements EntityMapper<Image> {
    @Override
    public Image toEntity(HttpServletRequest request) throws IOException, ServletException { // todo mapperexception
        String imageName = request.getParameter(SqlConstant.IMAGES_IMAGE_URL); //not sql
        byte[] imageData = extractBytes(request);
        return new Image(imageName, imageData);
    }

    private byte[] extractBytes(HttpServletRequest request) throws IOException, ServletException {
        Part part = request.getPart(SqlConstant.IMAGES_IMAGE_URL); //not sql
        InputStream inputStream = part.getInputStream();
        return inputStream.readAllBytes();
    }
}
