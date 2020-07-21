package com.training.rentapartment.controller.command.user;

import com.training.rentapartment.controller.Command;
import com.training.rentapartment.controller.command.PagePath;
import com.training.rentapartment.entity.Address;
import com.training.rentapartment.entity.Advertisement;
import com.training.rentapartment.entity.Image;
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

public class AddAdCommand implements Command {
    private static final String SPACE_APPENDER = " ";

    private UserService service;


    public AddAdCommand() {
        this.service = UserService.getINSTANCE();
    }

    public AddAdCommand(UserService service) {
        this.service = service;
    }

    @Override
    public String execute(HttpServletRequest request) { //TODO
        Image image = new Image();
        Address address = new Address();
        Advertisement advertisement = new Advertisement();

        String page = PagePath.MAIN;
        File file = null;
        Connection connection = ConnectionPool.getINSTANCE().getConnection();
        PreparedStatement statement = null;
        InputStream inputStream = null;

        try {
            Part part = request.getPart(SqlConstant.IMAGES_IMAGE_URL);
            System.out.println(part.getSize());
            inputStream = part.getInputStream();
            statement = connection.prepareStatement("INSERT INTO " + SqlConstant.IMAGES_TABLE_NAME +" "+ " (ad_id, image_id,image_data,image_name) " + "values(?,?,?,?)");
            statement.setInt(1, 1);
            statement.setInt(2, 1);
            statement.setBlob(3, inputStream);
            statement.setString(4, "test_image");
            statement.executeUpdate();
            page = PagePath.CLIENT;

        } catch (SQLException | ServletException | IOException exception) {
            exception.printStackTrace();
        }
        return page;
    }

}
