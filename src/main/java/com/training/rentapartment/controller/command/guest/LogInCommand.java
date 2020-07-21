package com.training.rentapartment.controller.command.guest;

import com.training.rentapartment.controller.Command;
import com.training.rentapartment.controller.command.PagePath;
import com.training.rentapartment.service.GuestService;

import javax.servlet.http.HttpServletRequest;

public class LogInCommand implements Command {
    private static final String LOGIN_PARAMETER = "login";
    private static final String PASSWORD_PARAMETER = "password";

    private final GuestService service;

    public LogInCommand() {
        this.service = GuestService.getINSTANCE();
    }

    public LogInCommand(GuestService service) {
        this.service = service;
    }

    @Override
    public String execute(HttpServletRequest request) { //TODO
        String page;
        String loginValue = request.getParameter(LOGIN_PARAMETER);
        String passwordValue = request.getParameter(PASSWORD_PARAMETER);
        if (service.logIn(loginValue, passwordValue)) {
            page = PagePath.CLIENT;
        } else {
            page = PagePath.LOGIN;
        }
        return page;
    }
}
