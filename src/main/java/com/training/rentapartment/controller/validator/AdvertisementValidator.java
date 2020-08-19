package com.training.rentapartment.controller.validator;

import com.training.rentapartment.model.repository.SqlConstant;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdvertisementValidator {
    private static final String PHONE_NUMBER_PATTERN = "^(\\+375)(29|25|44|33|17)(\\d{3})(\\d{2})(\\d{2})$";
    private static final String IMAGE_NAME_PATTERN = "\\w+(.jpg|.png|.bmp)$";
    private static final String CITY_NAME_PATTERN = "\\p{Upper}{1}\\p{Lower}+";
    private static final String STREET_NAME_PATTERN = "\\p{Upper}{1}\\p{Lower}+\\s{1}(avenue|street)$";
    private static final int MAX_HOUSE_NUMBER = 300;
    private static final int MAX_HOUSE_INDEX = 10;
    private static final int DESCRIPTION_PATTERN_NUMBER = 400;
    private static final int MIN_NUMBER = 0;
    private static final int MAX_FLOORS_NUMBER = 100;
    private static final int MAX_SQUARE_NUMBER = 1000;

    public static boolean validateAdvertisementRequest(HttpServletRequest request) {
        return validateAdvertisement(request) && validateImage(request) && validateAddress(request);
    }

    private static boolean validateAdvertisement(HttpServletRequest request) {
        Integer cost = Integer.parseInt(request.getParameter(SqlConstant.ADVERTISEMENT_COST)); //todo think how to check null ref
        Integer rooms = Integer.parseInt(request.getParameter(SqlConstant.ADVERTISEMENT_ROOMS));
        Integer floor = Integer.parseInt(request.getParameter(SqlConstant.ADVERTISEMENT_FLOOR));
        Double square = Double.parseDouble(request.getParameter(SqlConstant.ADVERTISEMENT_SQUARE));
        Double livingSquare = Double.parseDouble(request.getParameter(SqlConstant.ADVERTISEMENT_LIVING_SQUARE));
        Double kitchenSquare = Double.parseDouble(request.getParameter(SqlConstant.ADVERTISEMENT_KITCHEN_SQUARE));
        String phone = request.getParameter(SqlConstant.ADVERTISEMENT_PHONE);
        String description = request.getParameter(SqlConstant.ADVERTISEMENT_DESCRIPTION);
        boolean costMatcher = cost > MIN_NUMBER;
        if (cost <= MIN_NUMBER) { //todo like this
            return false;
        }
        boolean roomsMatcher = rooms > MIN_NUMBER;
        boolean floorMatcher = floor > MIN_NUMBER && floor < MAX_FLOORS_NUMBER;
        boolean squareMatcher = square > MIN_NUMBER && square < MAX_SQUARE_NUMBER;
        boolean livingSquareMatcher = livingSquare > MIN_NUMBER && livingSquare < MAX_SQUARE_NUMBER;
        boolean kitchenSquareMatcher = kitchenSquare > MIN_NUMBER && kitchenSquare < MAX_SQUARE_NUMBER;
        boolean phoneMatcher = matchPatternWithString(PHONE_NUMBER_PATTERN, phone);
        boolean descriptionMatcher = description.length() < DESCRIPTION_PATTERN_NUMBER;
        return costMatcher && roomsMatcher && floorMatcher && squareMatcher && livingSquareMatcher
                && kitchenSquareMatcher && phoneMatcher && descriptionMatcher;
    }

    private static boolean validateAddress(HttpServletRequest request) {
        boolean result = false;
        Integer houseNumber = Integer.parseInt(request.getParameter(SqlConstant.ADDRESS_HOUSE_NUMBER));
        Integer houseIndex = Integer.parseInt(request.getParameter(SqlConstant.ADDRESS_HOUSE_INDEX));
        String cityName = request.getParameter(SqlConstant.ADDRESS_CITY);
        String streetName = request.getParameter(SqlConstant.ADDRESS_STREET);
        if (houseIndex == null || houseNumber == null || cityName == null || streetName == null) {
            return result;
        } else {
            boolean cityMatcher = matchPatternWithString(CITY_NAME_PATTERN, cityName);
            boolean streetMatcher = matchPatternWithString(STREET_NAME_PATTERN, streetName);
            boolean houseNumberMatcher = houseNumber > MIN_NUMBER && houseNumber < MAX_HOUSE_NUMBER;
            boolean houseIndexMatcher = houseIndex > MIN_NUMBER && houseIndex < MAX_HOUSE_INDEX;
            result = cityMatcher && streetMatcher && houseIndexMatcher && houseNumberMatcher;
        }
        return result;
    }

    private static boolean validateImage(HttpServletRequest request) {
        String imageName = request.getParameter(SqlConstant.IMAGES_IMAGE_URL);
        return matchPatternWithString(IMAGE_NAME_PATTERN, imageName);
    }

    private static boolean matchPatternWithString(String pattern, String value) {
        Pattern loginPattern = Pattern.compile(pattern);
        Matcher loginMatcher = loginPattern.matcher(value);
        return loginMatcher.matches();
    }
}
