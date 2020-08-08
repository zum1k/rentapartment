package com.training.rentapartment.controller;

public class HttpRequestParameters {
    //user parameters
    public static final String LOGIN_PARAMETER = "login";
    public static final String PASSWORD_PARAMETER = "password";
    public static final String EMAIL_PARAMETER = "email";
    public static final String USER_ID_PARAMETER = "user_id";
    //image parameters
    public static final String IMAGE_NAME_PARAMETER = "image_name";
    public static final String IMAGE_DATA_PARAMETER = "image_data";
    //SQL table and columns names of ADVERTISEMENT
    public static final String COST_PARAMETER = "cost";
    public static final String ROOMS_PARAMETER = "rooms";
    public static final String FLOOR_PARAMETER = "floor";
    public static final String SQUARE_PARAMETER = "square";
    public static final String LIVING_SQUARE_PARAMETER = "living_square";
    public static final String KITCHEN_SQUARE_PARAMETER = "kitchen_square";
    public static final String OWNER_PARAMETER = "owner";
    public static final String PHONE_PARAMETER = "phone";
    public static final String DATE_PARAMETER = "addate";
    public static final String DESCRIPTION_PARAMETER = "description";
    public static final String PAGE_COUNT = "page_count";
    //SQL table and columns names of ADDRESS
    public static final String CITY_PARAMETER = "city";
    public static final String STREET_PARAMETER = "street";
    public static final String HOUSE_NUMBER_PARAMETER = "house_number";
    public static final String HOUSE_INDEX_PARAMETER = "house_index";
    private HttpRequestParameters(){}
}
