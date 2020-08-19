package com.training.rentapartment.controller.command.guest;

import com.training.rentapartment.controller.Command;
import com.training.rentapartment.controller.HttpRequestParameters;
import com.training.rentapartment.controller.command.CommandResult;
import com.training.rentapartment.controller.command.PagePath;
import com.training.rentapartment.exception.ServiceException;
import com.training.rentapartment.model.repository.impl.user.UserRepository;
import com.training.rentapartment.service.impl.AdvertisementServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class AllAdvertisementsCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(AllAdvertisementsCommand.class);
    private AdvertisementServiceImpl service;


    public AllAdvertisementsCommand() {
        this.service = AdvertisementServiceImpl.getINSTANCE();
    }

    public AllAdvertisementsCommand(AdvertisementServiceImpl service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) {
        int advertisementNumbers = Integer.parseInt(request.getParameter(HttpRequestParameters.PAGE_COUNT));
        int advertisementLimit = Integer.parseInt(request.getParameter(HttpRequestParameters.PAGE_LIMIT));
        try {
            service.allAdvertisements(advertisementNumbers, advertisementLimit);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return CommandResult.redirect(PagePath.MAIN);
    }
}
