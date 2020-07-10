package com.training.rentapartment.controller.command.impl.guest;

import com.training.rentapartment.controller.command.Command;
import com.training.rentapartment.controller.command.PagePath;
import com.training.rentapartment.service.GuestService;

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
