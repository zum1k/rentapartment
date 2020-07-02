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
import java.util.List;

public class UserRepository implements Repository<User>, AutoCloseable {
    private static final Logger LOGGER = LogManager.getLogger(UserRepository.class);

    private Connection connection;

    private static final String SELECT_QUERY = "SELECT * FROM ";
    private static final String DELETE_QUERY = "DELETE FROM ";

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(User user) {
        try {
            String sql = "INSERT INTO Products (login, password, email, type) Values (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getType().toString());
            preparedStatement.setString(5, user.getEmail());

            int rows = preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            LOGGER.error(exception.getMessage(), exception);
        }
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
        List<String> parameters = specification.receiveParameters();
        PreparedStatement preparedStatement = null;
        String sqlQuery = SELECT_QUERY + specification.toSqlRequest();
        int parametersLength = specification.receiveParameters().size();
        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            for (int i = 0; i < parametersLength; i++) {
                preparedStatement.setString(i + 1, parameters.get(i));
            }
            ResultSet resultSet = preparedStatement.executeQuery();

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
