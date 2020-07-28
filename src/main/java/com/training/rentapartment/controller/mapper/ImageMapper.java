package com.training.rentapartment.controller.mapper;

import com.training.rentapartment.controller.EntityMapper;
import com.training.rentapartment.entity.Image;
import com.training.rentapartment.model.SqlConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

public class ImageMapper implements EntityMapper<Image> {
    @Override
    public Image toEntity(HttpServletRequest request) throws IOException, ServletException { //TODO
        int adId = 1;
        int imageId = Integer.parseInt(request.getParameter(SqlConstant.IMAGES_ID));
        String imageName = request.getParameter(SqlConstant.IMAGES_IMAGE_URL);
        byte[] imageData = extractBytes(request);
        return new Image(adId, imageId, imageName, imageData);
    }

    private byte[] extractBytes(HttpServletRequest request) throws IOException, ServletException {
        Part part = request.getPart(SqlConstant.IMAGES_IMAGE_URL);
        InputStream inputStream = part.getInputStream();
        return inputStream.readAllBytes();
    }
}
