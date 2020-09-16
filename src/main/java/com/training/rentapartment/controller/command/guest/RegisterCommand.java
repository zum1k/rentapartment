package com.training.rentapartment.controller.command.guest;

import com.training.rentapartment.controller.Command;
import com.training.rentapartment.controller.HttpRequestParameters;
import com.training.rentapartment.controller.SessionAttribute;
import com.training.rentapartment.controller.command.CommandResult;
import com.training.rentapartment.controller.command.PagePath;
import com.training.rentapartment.controller.mapper.UserMapper;
import com.training.rentapartment.controller.validator.GuestValidator;
import com.training.rentapartment.entity.User;
import com.training.rentapartment.entity.UserType;
import com.training.rentapartment.exception.CommandException;
import com.training.rentapartment.exception.ServiceException;
import com.training.rentapartment.service.GuestService;
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

    private GuestService service;

    public RegisterCommand() {
        this.service = new GuestServiceImpl();
    }

    public RegisterCommand(GuestServiceImpl service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws CommandException {
        String page = PagePath.REGISTRATION;
        GuestValidator guestValidator = new GuestValidator();
        if (guestValidator.validateRegistration(request.getParameter(HttpRequestParameters.LOGIN),
                request.getParameter(HttpRequestParameters.PASSWORD),
                request.getParameter(HttpRequestParameters.EMAIL))) {
            try {
                User user = new UserMapper().toEntity(request);
                user.setType(UserType.CLIENT);
                Optional<User> currentUser = service.register(user);
                if (currentUser.isPresent()) {
                    request.getSession().setAttribute(SessionAttribute.USER, currentUser.get());
                    return CommandResult.redirect(PagePath.LINK_TO_MAIN);
                }
            } catch (IOException | ServletException | ServiceException e) {
                LOGGER.error(e.getMessage(), e);
                throw new CommandException(e.getMessage(), e);
            }
        }
        return CommandResult.forward(page);
    }
}
