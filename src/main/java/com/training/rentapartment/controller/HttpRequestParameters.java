package com.training.rentapartment.controller;

public class HttpRequestParameters {
    //user parameters
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String EMAIL = "email";
    public static final String USER_ID = "user_id";
    //image parameters
    public static final String IMAGE_NAME = "image_name";
    public static final String IMAGE_DATA = "image_data";
    //SQL table and columns names of ADVERTISEMENT
    public static final String COST = "cost";
    public static final String ROOMS = "rooms";
    public static final String FLOOR = "floor";
    public static final String SQUARE = "square";
    public static final String LIVING_SQUARE = "living_square";
    public static final String KITCHEN_SQUARE = "kitchen_square";
    public static final String OWNER = "owner";
    public static final String PHONE = "phone";
    public static final String ADDATE = "addate";
    public static final String DESCRIPTION = "description";
    public static final String PAGE_COUNT = "page_count";
    public static final String PAGE_LIMIT = "page_limit";
    //SQL table and columns names of ADDRESS
    public static final String CITY = "city";
    public static final String STREET = "street";
    public static final String HOUSE_NUMBER = "house_number";
    public static final String HOUSE_INDEX = "house_index";
    private HttpRequestParameters(){}
}
