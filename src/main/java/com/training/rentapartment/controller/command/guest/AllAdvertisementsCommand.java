package com.training.rentapartment.controller.command.guest;

import com.training.rentapartment.controller.Command;
import com.training.rentapartment.controller.HttpRequestParameters;
import com.training.rentapartment.controller.SessionAttribute;
import com.training.rentapartment.controller.command.CommandResult;
import com.training.rentapartment.controller.command.PagePath;
import com.training.rentapartment.entity.dto.AdvertisementDto;
import com.training.rentapartment.exception.CommandException;
import com.training.rentapartment.exception.ServiceException;
import com.training.rentapartment.service.impl.AdvertisementServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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
    public CommandResult execute(HttpServletRequest request) throws CommandException {
        int advertisementNumbers = Integer.parseInt(request.getParameter(HttpRequestParameters.PAGE_COUNT));
        int advertisementLimit = Integer.parseInt(request.getParameter(HttpRequestParameters.PAGE_LIMIT));
        try {
            List<AdvertisementDto> dtoList = service.allAdvertisements(advertisementNumbers, advertisementLimit);
            setDtosInSession(dtoList, request);
        } catch (ServiceException e) {
            LOGGER.error(e.getMessage(), e);
            throw new CommandException(e.getMessage(), e);
        }
        return CommandResult.redirect(PagePath.MAIN);
    }

    private void setDtosInSession(List<AdvertisementDto> dtoList, HttpServletRequest request) {
        request.setAttribute(SessionAttribute.ADVERTISEMENTS, dtoList);
    }
}
