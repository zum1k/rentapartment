package com.training.rentapartment.model.repository;

public class SqlConstant {
    public static final String SELECT_QUERY = "SELECT * FROM ";
    public static final String DELETE_QUERY = "DELETE FROM ";
    public static final String INSERT_QUERY = "INSERT INTO ";
    //SQL table and columns names of USER
    public static final String USER_TABLE_NAME = "users";
    public static final String USER_LOGIN = "login";
    public static final String USER_PASSWORD = "password";
    public static final String USER_EMAIL = "email";
    public static final String USER_ID = "user_id";
    public static final String USER_TYPE = "type";
    public static final String USER_VERIFIED = "verified";
    //SQL table and columns names of IMAGES
    public static final String IMAGES_TABLE_NAME = "images";
    public static final String IMAGES_ID = "image_id";
    public static final String IMAGES_IMAGE_URL = "image_name";
    public static final String IMAGES_IMAGE_DATA = "image_data";
    //SQL table and columns names of ADVERTISEMENT
    public static final String ADVERTISEMENT_TABLE_NAME = "ad";
    public static final String ADVERTISEMENT_ID = "ad_id";
    public static final String ADVERTISEMENT_COST = "cost";
    public static final String ADVERTISEMENT_ROOMS = "rooms";
    public static final String ADVERTISEMENT_FLOOR = "floor";
    public static final String ADVERTISEMENT_SQUARE = "square";
    public static final String ADVERTISEMENT_LIVING_SQUARE = "livingsquare";
    public static final String ADVERTISEMENT_KITCHEN_SQUARE = "kitchensquare";
    public static final String ADVERTISEMENT_OWNER = "owner";
    public static final String ADVERTISEMENT_PHONE = "phone";
    public static final String ADVERTISEMENT_DATE = "addate";
    public static final String ADVERTISEMENT_DESCRIPTION = "description";
    //SQL table and columns names of ADDRESS
    public static final String ADDRESS_TABLE_NAME = "address";
    public static final String ADDRESS_ID = "address_id";
    public static final String ADDRESS_CITY = "city";
    public static final String ADDRESS_STREET = "street";
    public static final String ADDRESS_HOUSE_NUMBER = "housenumber";
    public static final String ADDRESS_HOUSE_INDEX = "houseindex";
}
