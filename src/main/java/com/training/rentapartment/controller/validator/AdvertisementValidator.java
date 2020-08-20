package com.training.rentapartment.controller.validator;

import com.training.rentapartment.controller.HttpRequestParameters;
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
    private static final int MIN_NUMBER = 1;
    private static final int MAX_FLOORS_NUMBER = 100;
    private static final int MAX_SQUARE_NUMBER = 1000;

    public static boolean validateAdvertisementRequest(HttpServletRequest request) {
        return validateAdvertisement(request) && validateImage(request) && validateAddress(request);
    }

    private static boolean validateAdvertisement(HttpServletRequest request) {
        Integer cost = Integer.parseInt(request.getParameter(HttpRequestParameters.COST));
        Integer rooms = Integer.parseInt(request.getParameter(HttpRequestParameters.ROOMS));
        Integer floor = Integer.parseInt(request.getParameter(HttpRequestParameters.FLOOR));
        Double square = Double.parseDouble(request.getParameter(HttpRequestParameters.SQUARE));
        Double livingSquare = Double.parseDouble(request.getParameter(HttpRequestParameters.LIVING_SQUARE));
        Double kitchenSquare = Double.parseDouble(request.getParameter(HttpRequestParameters.KITCHEN_SQUARE));
        String phone = request.getParameter(HttpRequestParameters.PHONE);
        String description = request.getParameter(HttpRequestParameters.DESCRIPTION);

        if (cost >= MIN_NUMBER) {
            return false;
        }
        if (rooms >= MIN_NUMBER) {
            return false;
        }
        if (floor >= MIN_NUMBER && floor <= MAX_FLOORS_NUMBER) {
            return false;
        }
        if (square >= MIN_NUMBER && square <= MAX_SQUARE_NUMBER) {
            return false;
        }
        if (livingSquare > MIN_NUMBER && livingSquare < MAX_SQUARE_NUMBER) {
            return false;
        }
        if (kitchenSquare > MIN_NUMBER && kitchenSquare < MAX_SQUARE_NUMBER) {
            return false;
        }
        if (matchPatternWithString(PHONE_NUMBER_PATTERN, phone)) {
            return false;
        }
        if (description.length() < DESCRIPTION_PATTERN_NUMBER) {
            return false;
        }
        return true;
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
