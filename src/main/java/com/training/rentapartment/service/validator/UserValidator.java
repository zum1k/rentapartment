package com.training.rentapartment.service.validator;

public class UserValidator {
    static final String PASSWORD_PATTERN = "^[\\p{Alpha}\\d]{9,14}$ ";

    public boolean validateAddingAd(){
        return false;
    }
    public boolean validateDeletingAccount(){
        return false;
    }
}
