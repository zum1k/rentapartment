package com.training.rentapartment.model.repository.image;

import com.training.rentapartment.entity.Image;
import com.training.rentapartment.entity.User;
import com.training.rentapartment.model.Repository;
import com.training.rentapartment.model.SqlConstant;
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
import java.util.Map;
import java.util.Optional;

public class ImageRepository implements Repository<Image>, AutoCloseable {
    private static final Logger LOGGER = LogManager.getLogger(ImageRepository.class);
    private Connection connection;

    private static final String SELECT_QUERY = "SELECT * FROM ";
    private static final String DELETE_QUERY = "DELETE FROM ";
    private static final String INSERT_QUERY = "INSERT INTO ";

    public ImageRepository() {
        this.connection = ConnectionPool.getINSTANCE().getConnection();
    }

    @Override
    public void add(Image image) {
        doAdd(image);
    }

    @Override
    public void remove(Specification specification) {
        doDelete(specification);
    }

    @Override
    public List<Image> query(Specification specification) {
        return doQuery(specification);
    }

    @Override
    public Optional<Image> singleQuery(Specification specification) {
        List<Image> queriedImages= doQuery(specification);
        if (queriedImages.size() == 1) {
            return Optional.of(queriedImages.get(0));
        }
        return Optional.empty();
    }

    @Override
    public void close() throws Exception {
        ConnectionPool connectionPool = ConnectionPool.getINSTANCE();
        connectionPool.releaseConnection(connection);
    }

    private List<Image> doQuery(Specification specification) {
        List<Image> queriedImages = new ArrayList<>();
        List<Object> parameters = specification.receiveParameters();
        String sqlQuery = SELECT_QUERY + SqlConstant.USER_TABLE_NAME + specification.toSqlRequest();
        int parametersLength = specification.receiveParameters().size();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            for (int i = 0; i < parametersLength; i++) {
                preparedStatement.setString(i + 1, parameters.get(i).toString());
            }
            resultSet = preparedStatement.executeQuery();
            queriedImages = new ImageMapperImpl().toEntity(resultSet);

        } catch (SQLException exception) {
            LOGGER.error(exception.getMessage(), exception);
        }
        return queriedImages;
    }

    private void doDelete(Specification specification) {
        String sqlQuery = DELETE_QUERY + SqlConstant.USER_TABLE_NAME + " " + specification.toSqlRequest();
        int parametersLength = specification.receiveParameters().size();
        List<Object> parameters = specification.receiveParameters();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            for (int i = 0; i < parametersLength; i++) {
                preparedStatement.setString(i + 1, parameters.get(i).toString());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            LOGGER.error(exception.getMessage(), exception);
        }
    }

    private void doAdd(Image image) {
        try {
            Map<String, Object> fields = new ImageMapperImpl().toEntityFields(image);
            String sql = INSERT_QUERY + User.USER_TABLE_NAME + doInsertQuery(fields);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int i = 1;
            for (Map.Entry<String, Object> entry : fields.entrySet()) {
                Object value = entry.getValue();
                preparedStatement.setString(i++, String.valueOf(value));
            }
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            LOGGER.error(exception.getMessage(), exception);
        }
    }

    private String doInsertQuery(Map<String, Object> fields) {
        StringBuilder columns = new StringBuilder(" (");
        StringBuilder values = new StringBuilder("VALUES (");
        for (Map.Entry<String, Object> entry : fields.entrySet()) {
            String column = entry.getKey();
            columns.append(column).append(", ");
            values.append("?, ");
        }
        columns.deleteCharAt(columns.lastIndexOf(","));
        values.deleteCharAt(values.lastIndexOf(","));
        columns.append(")");
        values.append(")");
        return columns.append(values).toString();
    }
}
