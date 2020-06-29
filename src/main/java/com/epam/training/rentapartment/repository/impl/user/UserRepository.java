package com.epam.training.rentapartment.repository.impl.user;

import com.epam.training.rentapartment.entity.User;
import com.epam.training.rentapartment.repository.Repository;
import com.epam.training.rentapartment.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserRepository implements Repository<User>, AutoCloseable {
    private static final Logger LOGGER = LogManager.getLogger(UserRepository.class);
    private Connection connection;

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(User user) {
    }

    @Override
    public void remove(User user) {
    }

    @Override
    public void update(User user) {
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public List<User> query(Specification specification) {
        List<User> queriedUsers = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(specification.toSqlRequest());
            ResultSet resultSet = statement.executeQuery();

            User user = new User();

            user.setId(resultSet.getInt(1));
            user.setLogin(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
            user.setEmail(resultSet.getString(4));

           queriedUsers.add(user);

        } catch (SQLException exception) {
            LOGGER.error(exception.getMessage(), exception);
        }
        return queriedUsers;
    }

    @Override
    public void close() throws Exception {

    }
}
