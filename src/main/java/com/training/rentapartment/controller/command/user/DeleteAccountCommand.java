package com.training.rentapartment.controller.command.user;

import com.training.rentapartment.controller.Command;
import com.training.rentapartment.controller.SessionAttribute;
import com.training.rentapartment.controller.command.CommandResult;
import com.training.rentapartment.controller.command.PagePath;
import com.training.rentapartment.controller.mapper.UserMapper;
import com.training.rentapartment.exception.CommandException;
import com.training.rentapartment.exception.ServiceException;
import com.training.rentapartment.service.UserService;
import com.training.rentapartment.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class DeleteAccountCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(DeleteAccountCommand.class);
    private final UserService service;

    public DeleteAccountCommand() {
        this.service = new UserServiceImpl();
    }

    public DeleteAccountCommand(UserServiceImpl service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws CommandException {
        if (request.getSession().getAttribute(SessionAttribute.USER) != null) {
            try {
                UserMapper mapper = new UserMapper();
                int userId = mapper.parseSession(request).getId();
                service.deleteAccount(userId);
                request.getSession().invalidate();
                return CommandResult.forward(PagePath.LINK_TO_MAIN);
            } catch (ServiceException e) {
                LOGGER.error(e.getMessage(), e);
                throw new CommandException(e.getMessage(), e);
            }
        }
        return CommandResult.forward(PagePath.CLIENT);
    }
}
