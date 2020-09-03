package com.training.rentapartment.controller.command.guest;

import com.training.rentapartment.controller.Command;
import com.training.rentapartment.controller.SessionAttribute;
import com.training.rentapartment.controller.command.CommandResult;
import com.training.rentapartment.controller.command.PagePath;
import com.training.rentapartment.controller.validator.GuestValidator;
import com.training.rentapartment.entity.User;
import com.training.rentapartment.exception.CommandException;
import com.training.rentapartment.exception.ServiceException;
import com.training.rentapartment.service.impl.GuestServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class LogInCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(LogInCommand.class);
    private static final String LOGIN_PARAMETER = "login";
    private static final String PASSWORD_PARAMETER = "password";

    private final GuestServiceImpl service;

    public LogInCommand() {
        this.service = GuestServiceImpl.getInstance();
    }

    public LogInCommand(GuestServiceImpl service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws CommandException {
        String page = PagePath.MAIN;
        GuestValidator validator = new GuestValidator();
        if (validator.validateLogin(request.getParameter(LOGIN_PARAMETER),
                request.getParameter(PASSWORD_PARAMETER))) {
            try {
                String loginValue = request.getParameter(LOGIN_PARAMETER);
                String passwordValue = request.getParameter(PASSWORD_PARAMETER);
                Optional<User> currentUser = service.logIn(loginValue, passwordValue);
                if (currentUser.isPresent()) {
                    request.getSession().setAttribute(SessionAttribute.USER, currentUser);
                    page = PagePath.CLIENT;
                }
            } catch (ServiceException exception) {
                LOGGER.error(exception.getMessage(), exception);
                throw new CommandException(exception.getMessage(), exception);
            }
        }
        return CommandResult.forward(page);
    }
}
