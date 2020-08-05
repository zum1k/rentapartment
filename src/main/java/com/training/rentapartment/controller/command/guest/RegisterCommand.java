package com.training.rentapartment.controller.command.guest;

import com.training.rentapartment.controller.Command;
import com.training.rentapartment.controller.SessionAttribute;
import com.training.rentapartment.controller.command.CommandResult;
import com.training.rentapartment.controller.command.PagePath;
import com.training.rentapartment.controller.mapper.UserMapper;
import com.training.rentapartment.controller.utils.MailSender;
import com.training.rentapartment.controller.validator.GuestValidator;
import com.training.rentapartment.entity.User;
import com.training.rentapartment.service.GuestService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

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
    public CommandResult execute(HttpServletRequest request) { //TODO
        String page = null;
        String loginValue = request.getParameter(LOGIN_PARAMETER);
        String passwordValue = request.getParameter(PASSWORD_PARAMETER);
        String emailValue = request.getParameter(EMAIL_PARAMETER);
        if (GuestValidator.validateRegistration(loginValue, passwordValue, emailValue)) {
            try {
                User user = new UserMapper().toEntity(request);
                User currentUser = service.register(user);
                if (currentUser != null) {
                    request.getSession().setAttribute(SessionAttribute.USER_ID_ATTRIBUTE, currentUser);
                    page = PagePath.MAIN;
                    MailSender mailSender = new MailSender(VERIFICATION_EMAIL_SUBJECT, VERIFICATION_EMAIL_MESSAGE, emailValue);
                    mailSender.send();
                } else {
                    page = PagePath.REGISTRATION;
                }

            } catch (IOException | ServletException e) {
                e.printStackTrace();
            }
        } else {
            page = PagePath.REGISTRATION;
        }
        return CommandResult.redirect(page);
    }
}
