package com.training.rentapartment.controller.mapper;

import com.training.rentapartment.controller.EntityMapper;
import com.training.rentapartment.controller.HttpRequestParameters;
import com.training.rentapartment.controller.SessionAttribute;
import com.training.rentapartment.entity.Image;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ImageMapper implements EntityMapper<Image> {
    @Override
    public Image toEntity(HttpServletRequest request) throws IOException, ServletException {
        return null;
    }

    @Override
    public List<Image> toEntityList(HttpServletRequest request) throws IOException, ServletException {
        int advertisementId = Integer.parseInt(request.getParameter(HttpRequestParameters.ADVERTISEMENT_ID));
        Collection<Part> parts = request.getParts();
        List<Image> imageList = new ArrayList<>();
        for (Part part : parts) {
            Image image = parsePart(part, advertisementId);
            imageList.add(image);
        }
        return imageList;
    }

    private Image parsePart(Part part, int advertisementId) throws IOException, ServletException {
        byte[] bytes = extractBytes(part);
        String name = part.getName();
        Image image = new Image(name, bytes);
        image.setAdId(advertisementId);
        return image;
    }

    private byte[] extractBytes(Part part) throws IOException, ServletException {
        InputStream inputStream = part.getInputStream();
        return inputStream.readAllBytes();
    }
}
