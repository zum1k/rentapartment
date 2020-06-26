package com.epam.training.rentapartment.command.impl.guest;

import com.epam.training.rentapartment.command.Command;
import com.epam.training.rentapartment.command.PagePath;
import com.epam.training.rentapartment.service.GuestService;

import javax.servlet.http.HttpServletRequest;

public class LogInCommand implements Command {
    private static final String LOGIN_PARAMETER = "login";
    private static final String PASSWORD_PARAMETER = "password";

    private GuestService service;

    public LogInCommand(GuestService service) {
        this.service = service;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String loginValue = request.getParameter(LOGIN_PARAMETER);
        String passwordValue
                = request.getParameter(PASSWORD_PARAMETER);
        if (service.checkUser(loginValue, passwordValue)) {
            page = PagePath.MAIN;
        } else {
            page = PagePath.LOGIN;
        }
        return page;
    }
}
