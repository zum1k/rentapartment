package com.training.rentapartment.entity.dto;

public class ImageDto {
    private final String encoded64Image;

    public ImageDto(String image) {
        this.encoded64Image = image;
    }

    public String getImage() {
        return encoded64Image;
    }
}
