package com.training.rentapartment.model.repository.user;

import com.training.rentapartment.entity.User;
import com.training.rentapartment.entity.UserType;
import com.training.rentapartment.model.SqlEntityConverter;
import com.training.rentapartment.model.SqlConstant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperImpl implements SqlEntityConverter<User> {
    @Override
    public List<User> toEntity(ResultSet resultSet) throws SQLException {
        List<User> queriedUsers = new ArrayList<>();
        while (resultSet.next()) {
            try {
                User user = new User();
                user.setId(Integer.parseInt(resultSet.getString(SqlConstant.USER_ID)));
                user.setLogin(resultSet.getString(SqlConstant.USER_LOGIN));
                user.setPassword(resultSet.getString(SqlConstant.USER_PASSWORD));
                user.setType(UserType.valueOf(resultSet.getString(SqlConstant.USER_TYPE).toUpperCase()));
                user.setEmail(resultSet.getString(SqlConstant.USER_EMAIL));
                user.setVerified(resultSet.getBoolean(SqlConstant.USER_VERIFIED));
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
        fields.put(SqlConstant.USER_LOGIN, user.getLogin());
        fields.put(SqlConstant.USER_PASSWORD, user.getPassword());
        fields.put(SqlConstant.USER_TYPE, user.getType());
        fields.put(SqlConstant.USER_EMAIL, user.getEmail());
        fields.put(SqlConstant.USER_VERIFIED, user.getVerified());
        return fields;
    }
}
