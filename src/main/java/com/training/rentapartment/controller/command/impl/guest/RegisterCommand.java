package com.training.rentapartment.controller.command.impl.guest;

import com.training.rentapartment.controller.command.Command;
import com.training.rentapartment.controller.command.PagePath;
import com.training.rentapartment.controller.utils.MailSender;
import com.training.rentapartment.service.GuestService;

import javax.servlet.http.HttpServletRequest;

public class RegisterCommand implements Command {
    private static final String VERIFICATION_EMAIL_MESSAGE = "Hello, you received this message, " +
            "because you registered on RentApartment.com." +
            " For successful verification follow next link. Thank you.";
    private final String VERIFICATION_EMAIL_SUBJECT = "Continue Registration on RentApartment";
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
    public String execute(HttpServletRequest request) { //TODO
        String page;
        String loginValue = request.getParameter(LOGIN_PARAMETER);
        String passwordValue = request.getParameter(PASSWORD_PARAMETER);
        String emailValue = request.getParameter(EMAIL_PARAMETER);
        if (service.register(loginValue, passwordValue, emailValue)) {
            page = PagePath.MAIN;
            MailSender mailSender = new MailSender(VERIFICATION_EMAIL_SUBJECT, VERIFICATION_EMAIL_MESSAGE, emailValue);
            mailSender.send();
        } else {
            page = PagePath.LOGIN;
        }
        return page;
    }
}
