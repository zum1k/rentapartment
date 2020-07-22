package com.training.rentapartment.model.repository.user;

import com.training.rentapartment.entity.User;
import com.training.rentapartment.model.SqlConstant;
import com.training.rentapartment.model.pool.ConnectionPool;
import com.training.rentapartment.model.repository.AbstractRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class UserRepository extends AbstractRepository<User> {
    private static final Logger LOGGER = LogManager.getLogger(UserRepository.class);

    public UserRepository() {
        super(ConnectionPool.getINSTANCE().getConnection());
    }

    @Override
    protected List<User> toEntity(ResultSet resultSet) {
        List<User> users = null;
        try {
            users = new UserSqlMapper().toEntity(resultSet);
        } catch (SQLException exception) {
            LOGGER.error(exception.getMessage(), exception);
        }
        return users;
    }

    @Override
    protected Map<String, Object> toEntityFields(User user) {
        return new UserSqlMapper().toEntityFields(user);
    }

    @Override
    protected String getTableName() {
        return SqlConstant.USER_TABLE_NAME;
    }
}
