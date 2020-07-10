package com.training.rentapartment.model.repository.user;

import com.training.rentapartment.entity.User;
import com.training.rentapartment.model.EntityMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserMapperImpl implements EntityMapper<User> {


    @Override
    public List<User> toEntity(ResultSet resultSet) throws SQLException {
        List<User> queriedUsers = new ArrayList<>();
        while (resultSet.next()) {
            try {
                User user = new User();
                user.setId(Integer.parseInt(resultSet.getString(User.ID_INDEX)));
                user.setLogin(resultSet.getString(User.LOGIN_INDEX));
                user.setPassword(resultSet.getString(User.PASSWORD_INDEX));
                user.setEmail(resultSet.getString(User.EMAIL_INDEX));

                queriedUsers.add(user);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return queriedUsers;
    }
}
