package com.training.rentapartment.model.repository.user;

import com.training.rentapartment.entity.User;
import com.training.rentapartment.model.EntityMapper;
import com.training.rentapartment.model.SqlConstant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<String, Object> toEntityFields(User user) {
        Map<String, Object> fields = new HashMap<>();
        fields.put(SqlConstant.USER_ID, user.getId());
        fields.put(SqlConstant.LOGIN, user.getLogin());
        fields.put(SqlConstant.PASSWORD, user.getPassword());
        fields.put(SqlConstant.TYPE, user.getType());
        fields.put(SqlConstant.EMAIL, user.getEmail());
        return fields;
    }
}
