package com.training.rentapartment.controller.command.admin;

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

public class RegisterAdminCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(RegisterAdminCommand.class);
    private final GuestService service;

    public RegisterAdminCommand() {
        this.service = new GuestServiceImpl();
    }

    public RegisterAdminCommand(GuestServiceImpl service) {
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
                user.setType(UserType.ADMIN);
                Optional<User> currentUser = service.register(user);
                if (currentUser.isPresent()) {
                    request.getSession().setAttribute(SessionAttribute.USER, currentUser);
                    page = PagePath.CLIENT;
                }
            } catch (IOException | ServletException | ServiceException e) {
                LOGGER.error(e.getMessage(), e);
                throw new CommandException(e.getMessage(), e);
            }
        }
        return CommandResult.forward(page);
    }
}
