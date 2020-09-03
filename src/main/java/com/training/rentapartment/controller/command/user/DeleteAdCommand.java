package com.training.rentapartment.controller.command.user;

import com.training.rentapartment.controller.Command;
import com.training.rentapartment.controller.HttpRequestParameters;
import com.training.rentapartment.controller.command.CommandResult;
import com.training.rentapartment.controller.command.PagePath;
import com.training.rentapartment.controller.validator.impl.IntegerValidator;
import com.training.rentapartment.exception.CommandException;
import com.training.rentapartment.exception.ServiceException;
import com.training.rentapartment.service.AdvertisementService;
import com.training.rentapartment.service.impl.AdvertisementServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class DeleteAdCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(DeleteAdCommand.class);
    private final AdvertisementService advertisementService;

    public DeleteAdCommand() {
        this.advertisementService = AdvertisementServiceImpl.getInstance();
    }

    public DeleteAdCommand(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws CommandException {
        IntegerValidator validator = new IntegerValidator();
        String page = PagePath.EXCEPTION;
        if (validator.validate(HttpRequestParameters.ADVERTISEMENT_ID)) {
            try {
                int advertisementId = Integer.parseInt(request.getParameter(HttpRequestParameters.ADVERTISEMENT_ID));
                advertisementService.deleteAdvertisement(advertisementId);
                page = PagePath.CLIENT;
            } catch (ServiceException e) {
                LOGGER.error(e.getMessage(), e);
                throw new CommandException(e.getMessage(), e);
            }
        }
        return CommandResult.forward(page);
    }
}
