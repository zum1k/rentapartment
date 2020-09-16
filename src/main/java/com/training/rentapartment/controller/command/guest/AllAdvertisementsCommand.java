package com.training.rentapartment.controller.command.guest;

import com.training.rentapartment.controller.Command;
import com.training.rentapartment.controller.HttpRequestParameters;
import com.training.rentapartment.controller.command.CommandResult;
import com.training.rentapartment.controller.command.PagePath;
import com.training.rentapartment.entity.dto.AdvertisementDto;
import com.training.rentapartment.exception.CommandException;
import com.training.rentapartment.exception.ServiceException;
import com.training.rentapartment.service.AdvertisementService;
import com.training.rentapartment.service.impl.AdvertisementServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AllAdvertisementsCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(AllAdvertisementsCommand.class);
    private final int DEFAULT_OFFSET_VALUE = 0;
    private final int DEFAULT_LIMIT_VALUE = 50;
    private int advertisementOffset = DEFAULT_OFFSET_VALUE;
    private int advertisementLimit = DEFAULT_LIMIT_VALUE;

    private final AdvertisementService service;

    public AllAdvertisementsCommand() {
        this.service = new AdvertisementServiceImpl();
    }

    public AllAdvertisementsCommand(AdvertisementServiceImpl service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws CommandException {
        if (request.getParameter(HttpRequestParameters.PAGE_OFFSET) != null || request.getParameter(HttpRequestParameters.PAGE_LIMIT) != null) {
            advertisementOffset = Integer.parseInt(request.getParameter(HttpRequestParameters.PAGE_OFFSET));
            advertisementLimit = Integer.parseInt(request.getParameter(HttpRequestParameters.PAGE_LIMIT));
        }
        try {
            List<AdvertisementDto> dtoList = service.findAllAdvertisements(advertisementOffset, advertisementLimit);
            request.setAttribute(HttpRequestParameters.ADVERTISEMENTS, dtoList);
        } catch (ServiceException e) {
            LOGGER.error(e.getMessage(), e);
            throw new CommandException(e.getMessage(), e);
        }
        return CommandResult.forward(PagePath.MAIN);
    }
}

