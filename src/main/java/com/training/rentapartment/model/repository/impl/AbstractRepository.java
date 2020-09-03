package com.training.rentapartment.model.repository.impl;

import com.training.rentapartment.exception.RepositoryException;
import com.training.rentapartment.model.repository.Specification;
import com.training.rentapartment.model.repository.SqlConstant;
import com.training.rentapartment.model.repository.SqlQueryParameter;
import com.training.rentapartment.model.repository.Repository;

import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class AbstractRepository<T> implements Repository<T>, AutoCloseable {
    private Connection connection;

    public AbstractRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int add(T t) throws RepositoryException {
       return doAdd(t);
    }

    @Override
    public void remove(Specification specification) throws RepositoryException {
        doDelete(specification);
    }

    @Override
    public List<T> query(Specification specification) throws RepositoryException {
        return doQuery(specification);
    }

    @Override
    public Optional<T> singleQuery(Specification specification) throws RepositoryException {
        List<T> queriedUsers = doQuery(specification);
        if (queriedUsers.size() == 1) {
            return Optional.ofNullable(queriedUsers.get(0));
        }
        return Optional.empty();
    }

    @Override
    public void close() throws Exception {
        //TODO return connection to CP;
    }

    private List<T> doQuery(Specification specification) throws RepositoryException {
        List<T> queriedEntities;
        List<SqlQueryParameter> parameters = specification.receiveParameters();
        String sqlQuery = SqlConstant.SELECT_QUERY + getTableName() + specification.toSqlRequest();
        int parametersLength = specification.receiveParameters().size();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            for (int i = 0; i < parametersLength; i++) {
                preparedStatement.setString(i + 1, parameters.get(i).toString());
            }
            resultSet = preparedStatement.executeQuery();
            queriedEntities = toEntity(resultSet);

        } catch (SQLException exception) {
            throw new RepositoryException(exception.getMessage(), exception);
        }
        return queriedEntities;
    }

    private String doInsertQuery(Map<String, Object> fields) { //TODO
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

    private int doAdd(T t) throws RepositoryException { //TODO
        int keyId = 0;
        try {
            Map<String, Object> fields = toEntityFields(t);
            String sql = SqlConstant.INSERT_QUERY + getTableName() + doInsertQuery(fields);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int i = 1;
            for (Map.Entry<String, Object> entry : fields.entrySet()) {
                Object value = entry.getValue();
                preparedStatement.setString(i++, String.valueOf(value));
            }
            int affectedRows =  preparedStatement.executeUpdate();
            if(affectedRows == 0){
                String message = "Can't add Advertisement";
                throw new RepositoryException(message);
            }
            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    keyId =resultSet.getInt(1);
                }
            }
        } catch (SQLException exception) {
            throw new RepositoryException(exception.getMessage(), exception);
        }
        return keyId;
    }

    private void doDelete(Specification specification) throws RepositoryException {
        String sqlQuery = SqlConstant.DELETE_QUERY + getTableName() + " " + specification.toSqlRequest();
        int parametersLength = specification.receiveParameters().size();
        List<SqlQueryParameter> parameters = specification.receiveParameters();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            for (int i = 0; i < parametersLength; i++) {
                preparedStatement.setString(i + 1, parameters.get(i).toString());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new RepositoryException(exception.getMessage(), exception);
        }
    }

    protected abstract List<T> toEntity(ResultSet resultSet) throws SQLException;

    protected abstract Map<String, Object> toEntityFields(T t);

    protected abstract String getTableName();


}
