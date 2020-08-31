package com.training.rentapartment.controller.validator;

import com.training.rentapartment.controller.validator.impl.PatternValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Collection;

public class ImageValidator {
    private static final String IMAGE_EXTENSION_PATTERN = "jpg|png|bmp";

    public boolean validateImage(HttpServletRequest request) {
        try {
            Collection<Part> parts = request.getParts();
            for (Part part : parts) {
                String fileExtension = part.getContentType();
                PatternValidator validator = new PatternValidator(IMAGE_EXTENSION_PATTERN);
                if (!validator.validate(fileExtension)) {
                    return false;
                }
            }
        } catch (IOException | ServletException e) {
            return false;
        }
        return true;
    }
}
