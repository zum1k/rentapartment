package com.training.rentapartment.controller.command.guest;

import com.training.rentapartment.controller.Command;
import com.training.rentapartment.controller.SessionAttribute;
import com.training.rentapartment.controller.command.CommandResult;
import com.training.rentapartment.controller.command.PagePath;
import com.training.rentapartment.controller.validator.GuestValidator;
import com.training.rentapartment.entity.User;
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
    public CommandResult execute(HttpServletRequest request) { //TODO
        String page;
        String loginValue = request.getParameter(LOGIN_PARAMETER);
        String passwordValue = request.getParameter(PASSWORD_PARAMETER);
        if (GuestValidator.validateLogin(loginValue, passwordValue)) {
            User currentUser = service.logIn(loginValue, passwordValue);
            if (currentUser != null) {
                request.getSession().setAttribute(SessionAttribute.USER_ID_ATTRIBUTE, currentUser);
                page = PagePath.CLIENT;
            } else {
                page = PagePath.LOGIN;
            }
        } else {
            page = PagePath.LOGIN;
        }
        return CommandResult.redirect(page);
    }
}
