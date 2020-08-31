package com.training.rentapartment.controller.command.user;

import com.training.rentapartment.controller.Command;
import com.training.rentapartment.controller.command.CommandResult;
import com.training.rentapartment.controller.command.PagePath;
import com.training.rentapartment.controller.mapper.ImageMapper;
import com.training.rentapartment.entity.Image;
import com.training.rentapartment.exception.CommandException;
import com.training.rentapartment.exception.ServiceException;
import com.training.rentapartment.service.AdvertisementService;
import com.training.rentapartment.service.impl.AdvertisementServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public class UploadImagesCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(UploadImagesCommand.class);
    private final AdvertisementService service;

    public UploadImagesCommand(AdvertisementService service) {
        this.service = service;
    }

    public UploadImagesCommand() {
        this.service = AdvertisementServiceImpl.getInstance();
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws CommandException {
        try {
            List<Image> images = new ImageMapper().toEntityList(request);
            service.addImages(images);
        } catch (ServletException | IOException | ServiceException e) {
            LOGGER.error(e.getMessage(), e);
            throw new CommandException(e.getMessage(), e);
        }
        return CommandResult.forward(PagePath.CLIENT);
    }
}
