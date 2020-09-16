package com.training.rentapartment.controller.command.link;

import com.training.rentapartment.controller.Command;
import com.training.rentapartment.controller.HttpRequestParameters;
import com.training.rentapartment.controller.command.CommandResult;
import com.training.rentapartment.controller.command.PagePath;
import com.training.rentapartment.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

public class LinkToUploadImagesCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request) throws CommandException {
        request.setAttribute(HttpRequestParameters.ADVERTISEMENT_ID, request.getParameter(HttpRequestParameters.ADVERTISEMENT_ID));

        return CommandResult.forward(PagePath.IMAGES);
    }
}
