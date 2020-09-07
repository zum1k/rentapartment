package com.training.rentapartment.controller.command.guest;

import com.training.rentapartment.controller.Command;
import com.training.rentapartment.controller.SessionAttribute;
import com.training.rentapartment.controller.command.CommandResult;
import com.training.rentapartment.controller.command.PagePath;
import com.training.rentapartment.controller.mapper.UserMapper;
import com.training.rentapartment.controller.utils.MailSender;
import com.training.rentapartment.controller.validator.GuestValidator;
import com.training.rentapartment.entity.User;
import com.training.rentapartment.exception.CommandException;
import com.training.rentapartment.exception.ServiceException;
import com.training.rentapartment.service.impl.GuestServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

public class RegisterCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(RegisterCommand.class);
    private static final String VERIFICATION_EMAIL_MESSAGE = "Hello, you received this message, " +
            "because you registered on RentApartment.com." +
            " For successful verification follow next link. Thank you.";
    private final String VERIFICATION_EMAIL_SUBJECT = "Continue Registration on RentApartment";
    private static final String LOGIN_PARAMETER = "login";
    private static final String PASSWORD_PARAMETER = "password";
    private static final String EMAIL_PARAMETER = "email";

    private GuestServiceImpl service;

    public RegisterCommand() {
        this.service = GuestServiceImpl.getInstance();
    }

    public RegisterCommand(GuestServiceImpl service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws CommandException {
        String page = PagePath.REGISTRATION;
        GuestValidator guestValidator = new GuestValidator();
        if (guestValidator.validateRegistration(request.getParameter(LOGIN_PARAMETER),
                request.getParameter(PASSWORD_PARAMETER),
                request.getParameter(EMAIL_PARAMETER))) {
            try {
                User user = new UserMapper().toEntity(request);
                Optional<User> currentUser = service.register(user);
                if (currentUser.isPresent()) {
                    request.getSession().setAttribute(SessionAttribute.USER, currentUser);
                    page = PagePath.CLIENT;
                    MailSender mailSender = new MailSender(VERIFICATION_EMAIL_SUBJECT, VERIFICATION_EMAIL_MESSAGE,
                            request.getParameter(EMAIL_PARAMETER));
                    mailSender.send();
                }
            } catch (IOException | ServletException | ServiceException e) {
                e.printStackTrace();
            }
        }
        return CommandResult.forward(page);
    }
}
