package com.training.rentapartment.controller.command.guest;

import com.training.rentapartment.controller.Command;
import com.training.rentapartment.controller.HttpRequestParameters;
import com.training.rentapartment.controller.SessionAttribute;
import com.training.rentapartment.controller.command.CommandResult;
import com.training.rentapartment.controller.command.PagePath;
import com.training.rentapartment.controller.validator.impl.NotNullValidator;
import com.training.rentapartment.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

public class SetLocaleCommand implements Command {
    private static final String DEFAULT_LOCALE = "ru";
    public SetLocaleCommand() {
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws CommandException {
        NotNullValidator validator = new NotNullValidator();
        if (validator.validate(request.getParameter(HttpRequestParameters.LOCALE))) {
            request.getSession().setAttribute(SessionAttribute.LOCALE, request.getParameter(HttpRequestParameters.LOCALE));
            return CommandResult.forward(PagePath.LINK_TO_MAIN);
        }
        request.getSession().setAttribute(SessionAttribute.LOCALE, DEFAULT_LOCALE);
        return CommandResult.forward(PagePath.LINK_TO_MAIN);
    }
}
