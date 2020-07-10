package com.training.rentapartment.model.repository.user;

import com.training.rentapartment.model.SQLConstant;
import com.training.rentapartment.entity.User;
import com.training.rentapartment.model.Repository;
import com.training.rentapartment.model.Specification;
import com.training.rentapartment.model.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository implements Repository<User>, AutoCloseable {
    private static final Logger LOGGER = LogManager.getLogger(UserRepository.class);

    private Connection connection;

    private static final String SELECT_QUERY = "SELECT * FROM ";
    private static final String DELETE_QUERY = "DELETE FROM ";
    private static final String INSERT_QUERY = "INSERT INTO ";

    public UserRepository() {
        this.connection = ConnectionPool.getINSTANCE().getConnection();
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
    public List<User> query(Specification specification) {
        return doQuery(specification);
    }

    @Override
    public Optional<User> singleQuery(Specification specification) {
        List<User> queriedUsers = doQuery(specification);
        return Optional.ofNullable(queriedUsers.get(0));
    }

    @Override
    public void close() throws Exception {
        ConnectionPool connectionPool = ConnectionPool.getINSTANCE();
        connectionPool.releaseConnection(connection);
    }

    private List<User> doQuery(Specification specification) {
        List<User> queriedUsers = new ArrayList<>();
        List<Object> parameters = specification.receiveParameters();
        String sqlQuery = SELECT_QUERY + SQLConstant.USER_TABLE_NAME + specification.toSqlRequest();
        int parametersLength = specification.receiveParameters().size();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {

            for (int i = 0; i < parametersLength; i++) {
                preparedStatement.setString(i + 1, parameters.get(i).toString());
            }
            resultSet = preparedStatement.executeQuery();
            queriedUsers = new UserMapperImpl().toEntity(resultSet);

        } catch (SQLException exception) {
            LOGGER.error(exception.getMessage(), exception);
        }
        return queriedUsers;
    }

    private void doDelete() { //TODO

    }

    private void doAdd() { //TODO

    }
}
