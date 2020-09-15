package com.training.rentapartment.controller;

public class HttpRequestParameters {
    public static final String ERROR = "error";
    public static final String LOCALE = "locale";
    //user parameters
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String EMAIL = "email";
    public static final String USER_ID = "user_id";
    public static final String USERS = "users";
    //image parameters
    public static final String IMAGE_NAME = "image_name";
    public static final String IMAGE_DATA = "image_data";
    //SQL table and columns names of ADVERTISEMENT
    public static final String ADVERTISEMENT_ID = "advertisement_id";
    public static final String ADVERTISEMENTS = "advertisements";
    public static final String ADVERTISEMENT = "advertisement";
    public static final String COST = "cost";
    public static final String ROOMS = "rooms";
    public static final String FLOOR = "floor";
    public static final String SQUARE = "square";
    public static final String LIVING_SQUARE = "living_square";
    public static final String KITCHEN_SQUARE = "kitchen_square";
    public static final String OWNER = "owner";
    public static final String PHONE = "phone";
    public static final String DESCRIPTION = "description";
    public static final String PAGE_OFFSET = "page_offset";
    public static final String PAGE_LIMIT = "page_limit";
    //SQL table and columns names of ADDRESS
    public static final String CITY = "city";
    public static final String STREET = "street";
    public static final String HOUSE_NUMBER = "house_number";
    public static final String HOUSE_INDEX = "house_index";
    //Query filter parameters
    public static final String ROOM = "room";
    public static final String ROOM_MIN = "min_room";
    public static final String ROOM_MAX = "max_room";
    public static final String FLOOR_MIN = "min_floor";
    public static final String FLOOR_MAX = "max_floor";
    public static final String COST_MIN = "min_cost";
    public static final String COST_MAX = "max_cost";
    public static final String SQUARE_MIN = "min_square";
    public static final String SQUARE_MAX = "max_square";
    public static final String COMMAND = "command";

    private HttpRequestParameters() {
    }
}
