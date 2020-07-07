package com.epam.training.rentapartment.repository.impl.user;

import com.epam.training.rentapartment.connection.ConnectionPool;
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
    private static final String INSERT_QUERY = "INSERT INTO ";

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(User user) { //TODO
        try {
            String sql = INSERT_QUERY + User.USER_TABLE_NAME + " (login, password, email, type) Values (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getType().toString());
            preparedStatement.setString(4, user.getEmail());

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
        String sqlQuery = SELECT_QUERY + specification.toSqlRequest();
        int parametersLength = specification.receiveParameters().size();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {

            for (int i = 0; i < parametersLength; i++) {
                preparedStatement.setString(i + 1, parameters.get(i));
            }
            resultSet = preparedStatement.executeQuery();
            queriedUsers = new UserMapperImpl().toEntity(resultSet);

        } catch (SQLException exception) {
            LOGGER.error(exception.getMessage(), exception);
        }
        return queriedUsers;
    }

    @Override
    public void close() throws Exception {
        ConnectionPool connectionPool = ConnectionPool.getINSTANCE();
        connectionPool.releaseConnection(connection);
    }
}
