package com.training.rentapartment.controller.command.user;

import com.training.rentapartment.controller.Command;
import com.training.rentapartment.controller.command.PagePath;
import com.training.rentapartment.controller.mapper.AddressMapper;
import com.training.rentapartment.controller.mapper.AdvertisementMapper;
import com.training.rentapartment.controller.mapper.ImageMapper;
import com.training.rentapartment.entity.Address;
import com.training.rentapartment.entity.Advertisement;
import com.training.rentapartment.entity.Image;
import com.training.rentapartment.exception.CommandException;
import com.training.rentapartment.model.SqlConstant;
import com.training.rentapartment.model.pool.ConnectionPool;
import com.training.rentapartment.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddAdvertisementCommand implements Command {
    private static final String SPACE_APPENDER = " ";

    private UserService service;


    public AddAdvertisementCommand() {
        this.service = UserService.getINSTANCE();
    }

    public AddAdvertisementCommand(UserService service) {
        this.service = service;
    }

    @Override
    public String execute(HttpServletRequest request){ //TODO
        String page = null;
        try {
            Image image = new ImageMapper().toEntity(request);
        } catch (IOException | ServletException e) {
            return PagePath.EXCEPTION;
        }
        Address address = new AddressMapper().toEntity(request);
        Advertisement advertisement = new AdvertisementMapper().toEntity(request);

//        String page = PagePath.MAIN;
//        File file = null;
//        Connection connection = ConnectionPool.getINSTANCE().getConnection();
//        PreparedStatement statement = null;
//        InputStream inputStream = null;
//
//        try {
//            Part part = request.getPart(SqlConstant.IMAGES_IMAGE_URL);
//            System.out.println(part.getSize());
//            inputStream = part.getInputStream();
//            image.setImageData(inputStream.readAllBytes());
//            byte[]bytes = inputStream.readAllBytes();
//            statement = connection.prepareStatement("INSERT INTO " + SqlConstant.IMAGES_TABLE_NAME +" "+ " (ad_id, image_id,image_data,image_name) " + "values(?,?,?,?)");
//            statement.setInt(1, 1);
//            statement.setInt(2, 1);
//            statement.setBlob(3, inputStream);
//            statement.setString(4, "test_image");
//            statement.executeUpdate();
//            page = PagePath.CLIENT;
//
//        } catch (SQLException | ServletException | IOException exception) {
//            exception.printStackTrace();
//        }
//        return page;
    }

}
