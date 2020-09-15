package com.training.rentapartment.controller.command.user;

import com.training.rentapartment.controller.Command;
import com.training.rentapartment.controller.HttpRequestParameters;
import com.training.rentapartment.controller.SessionAttribute;
import com.training.rentapartment.controller.command.CommandResult;
import com.training.rentapartment.controller.command.PagePath;
import com.training.rentapartment.controller.mapper.UserMapper;
import com.training.rentapartment.entity.dto.AdvertisementDto;
import com.training.rentapartment.exception.CommandException;
import com.training.rentapartment.exception.ServiceException;
import com.training.rentapartment.service.AdvertisementService;
import com.training.rentapartment.service.impl.AdvertisementServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowUserAdvertisementsCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(ShowUserAdvertisementsCommand.class);
    private final AdvertisementService advertisementService;

    public ShowUserAdvertisementsCommand() {
        this.advertisementService = new AdvertisementServiceImpl();
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws CommandException {
        String page = PagePath.MAIN;
        if (request.getSession().getAttribute(SessionAttribute.USER) != null) {
            UserMapper mapper = new UserMapper();
            int userId = mapper.parseSession(request).getId();
            try {
                List<AdvertisementDto> dtos = advertisementService.findUserAdvertisements(userId);
                request.setAttribute(HttpRequestParameters.ADVERTISEMENTS, dtos);
                page = PagePath.CLIENT;
            } catch (ServiceException e) {
                LOGGER.error(e.getMessage(), e);
                throw new CommandException(e.getMessage(), e);
            }
        }
        return CommandResult.forward(page);
    }
}
