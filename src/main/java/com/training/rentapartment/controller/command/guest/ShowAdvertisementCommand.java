package com.training.rentapartment.controller.command.guest;

import com.training.rentapartment.controller.Command;
import com.training.rentapartment.controller.HttpRequestParameters;
import com.training.rentapartment.controller.command.CommandResult;
import com.training.rentapartment.controller.command.PagePath;
import com.training.rentapartment.controller.validator.impl.IntegerValidator;
import com.training.rentapartment.entity.dto.AdvertisementDto;
import com.training.rentapartment.exception.CommandException;
import com.training.rentapartment.exception.ServiceException;
import com.training.rentapartment.service.impl.AdvertisementServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class ShowAdvertisementCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(ShowAdvertisementCommand.class);
    private final AdvertisementServiceImpl advertisementService;

    public ShowAdvertisementCommand(AdvertisementServiceImpl advertisementService) {
        this.advertisementService = advertisementService;
    }

    public ShowAdvertisementCommand() {
        this.advertisementService = AdvertisementServiceImpl.getInstance();
    }


    @Override
    public CommandResult execute(HttpServletRequest request) throws CommandException {
        String page = PagePath.MAIN;
        IntegerValidator validator = new IntegerValidator();
        if (validator.validate(request.getParameter(HttpRequestParameters.ADVERTISEMENT_ID))) {
            int advertisementId = Integer.parseInt(request.getParameter(HttpRequestParameters.ADVERTISEMENT_ID));
            try {
                AdvertisementDto dto = advertisementService.findSingleAdvertisement(advertisementId)
                        .orElseThrow(() -> new CommandException("Can't find any advertisement"));
                request.setAttribute(HttpRequestParameters.ADVERTISEMENT, dto);
                page = PagePath.ADVERTISEMENT;
            } catch (ServiceException e) {
                LOGGER.error(e.getMessage());
                throw new CommandException(e.getMessage(), e);
            }
        }
        return CommandResult.forward(page);
    }
}
