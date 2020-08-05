package com.training.rentapartment.entity;

import java.util.Objects;

public class Image {
    public static final String IMAGE_TABLE_NAME = "image";

    private int adId;
    private int imageId;
    private String imageURL;
    private byte[] imageData;

    public Image() {
    }

    public Image(String imageURL, byte[] imageData) {
        this.imageURL = imageURL;
        this.imageData = imageData;
    }

    public int getAdId() {
        return adId;
    }

    public void setAdId(int adId) {
        this.adId = adId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Image image = (Image) o;
        return adId == image.adId &&
                imageId == image.imageId &&
                Objects.equals(imageURL, image.imageURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adId, imageId, imageURL, imageData);
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Image{" + "adId=")
                .append(adId).append(", imageId=")
                .append(imageId).append(", imageURL='")
                .append(imageURL).append('\'')
                .append('}').toString();
    }
}
