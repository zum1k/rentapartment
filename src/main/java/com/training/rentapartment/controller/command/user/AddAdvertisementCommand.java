package com.training.rentapartment.controller.command.user;

import com.training.rentapartment.controller.Command;
import com.training.rentapartment.controller.HttpRequestParameters;
import com.training.rentapartment.controller.command.CommandResult;
import com.training.rentapartment.controller.command.PagePath;
import com.training.rentapartment.controller.mapper.AddressMapper;
import com.training.rentapartment.controller.mapper.AdvertisementMapper;
import com.training.rentapartment.controller.validator.AdvertisementValidator;
import com.training.rentapartment.entity.Address;
import com.training.rentapartment.entity.Advertisement;
import com.training.rentapartment.exception.CommandException;
import com.training.rentapartment.exception.ServiceException;
import com.training.rentapartment.service.impl.AdvertisementServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class AddAdvertisementCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(AddAdvertisementCommand.class);
    private AdvertisementServiceImpl service;

    public AddAdvertisementCommand() {
        this.service = AdvertisementServiceImpl.getInstance();
    }

    public AddAdvertisementCommand(AdvertisementServiceImpl service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws CommandException {
        String page = PagePath.ADD_ADVERTISEMENT;
        AdvertisementValidator validator = new AdvertisementValidator();
        if (validator.validateAdvertisement(request)) {
            try {
                Address address = new AddressMapper().toEntity(request);
                Advertisement advertisement = new AdvertisementMapper().toEntity(request);
                int advertisementId = service.addAdvertisement(advertisement, address);
                request.setAttribute(HttpRequestParameters.ADVERTISEMENT_ID, advertisementId);
                page = PagePath.IMAGES;
            } catch (ServiceException e) {
                LOGGER.error(e.getMessage(), e);
                throw new CommandException(e.getMessage(), e);
            }
        }
        return CommandResult.forward(page);
    }
}
