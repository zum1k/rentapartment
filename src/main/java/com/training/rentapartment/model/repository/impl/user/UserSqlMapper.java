package com.training.rentapartment.model.repository.impl.user;

import com.training.rentapartment.entity.User;
import com.training.rentapartment.entity.UserType;
import com.training.rentapartment.model.repository.SqlConstant;
import com.training.rentapartment.model.repository.SqlMapper;
import com.training.rentapartment.model.repository.SqlQueryParameter;
import com.training.rentapartment.model.repository.specification.queryparameters.IntegerSqlQueryParameter;
import com.training.rentapartment.model.repository.specification.queryparameters.StringSqlQueryParameter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserSqlMapper implements SqlMapper<User> {
    @Override
    public List<User> toEntity(ResultSet resultSet) throws SQLException {
        List<User> queriedList = new ArrayList<>();
        while (resultSet.next()) {
            try {
                User user = new User();
                user.setId(Integer.parseInt(resultSet.getString(SqlConstant.USER_ID)));
                user.setLogin(resultSet.getString(SqlConstant.USER_LOGIN));
                user.setPassword(resultSet.getString(SqlConstant.USER_PASSWORD));
                user.setType(UserType.valueOf(resultSet.getString(SqlConstant.USER_TYPE).toUpperCase()));
                user.setEmail(resultSet.getString(SqlConstant.USER_EMAIL));
                user.setVerified(resultSet.getInt(SqlConstant.USER_VERIFIED));
                queriedList.add(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return queriedList;
    }

    @Override
    public Map<String, SqlQueryParameter> toEntityFields(User user) {
        Map<String, SqlQueryParameter> fields = new HashMap<>();
        fields.put(SqlConstant.USER_LOGIN, new StringSqlQueryParameter(user.getLogin()));
        fields.put(SqlConstant.USER_PASSWORD, new StringSqlQueryParameter(user.getPassword()));
        fields.put(SqlConstant.USER_TYPE, new StringSqlQueryParameter(user.getType().toString()));
        fields.put(SqlConstant.USER_EMAIL, new StringSqlQueryParameter(user.getEmail()));
        fields.put(SqlConstant.USER_VERIFIED, new IntegerSqlQueryParameter(user.getVerified()));
        return fields;
    }
}
