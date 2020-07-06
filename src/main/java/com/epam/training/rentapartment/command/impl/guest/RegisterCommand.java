package com.epam.training.rentapartment.command.impl.guest;

import com.epam.training.rentapartment.command.Command;
import com.epam.training.rentapartment.command.PagePath;
import com.epam.training.rentapartment.service.GuestService;

import javax.servlet.http.HttpServletRequest;

public class RegisterCommand implements Command {
    private static final String LOGIN_PARAMETER = "login";
    private static final String PASSWORD_PARAMETER = "password";
    private static final String EMAIL_PARAMETER = "email";

    private GuestService service;

    public RegisterCommand() {
        this.service = GuestService.getINSTANCE();
    }

    public RegisterCommand(GuestService service) {
        this.service = service;
    }

    @Override
    public String execute(HttpServletRequest request) {
        return PagePath.MAIN;
    }
}
