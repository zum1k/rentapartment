package com.training.rentapartment.model.repository.impl;

import com.training.rentapartment.exception.RepositoryException;
import com.training.rentapartment.model.pool.ConnectionPool;
import com.training.rentapartment.model.repository.Repository;
import com.training.rentapartment.model.repository.Specification;
import com.training.rentapartment.model.repository.SqlConstant;
import com.training.rentapartment.model.repository.SqlQueryParameter;

import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class AbstractRepository<T> implements Repository<T>, AutoCloseable {
    private final String doublePType = "DOUBLE";
    private final String intType = "INT";
    private final String stringType = "STRING";
    private final String blobType = "BYTE";


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
            return Optional.of(queriedUsers.get(0));
        }
        return Optional.empty();
    }

    @Override
    public void close() throws Exception {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        connectionPool.releaseConnection(connection);
    }

    private List<T> doQuery(Specification specification) throws RepositoryException {
        List<T> queriedEntities;
        String sqlQuery = SqlConstant.SELECT_QUERY + getTableName() + specification.toSqlRequest();
        try {
            PreparedStatement preparedStatement = setPreparedStatement(sqlQuery, specification);
            ResultSet resultSet = preparedStatement.executeQuery();
            queriedEntities = toEntity(resultSet);
        } catch (SQLException exception) {
            throw new RepositoryException(exception.getMessage(), exception);
        }
        return queriedEntities;
    }

    private int doAdd(T t) throws RepositoryException {
        try {
            Map<String, SqlQueryParameter> fields = toEntityFields(t);
            String sql = SqlConstant.INSERT_QUERY + getTableName() + doInsertQuery(fields);
            PreparedStatement preparedStatement = setInsertPreparedStatement(sql, fields);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new RepositoryException("Can't add.");
            }
            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                int key = 0;
                if (resultSet.next()) {
                    key = resultSet.getInt(1);
                }
                return key;
            }
        } catch (SQLException exception) {
            throw new RepositoryException(exception.getMessage(), exception);
        }
    }

    private String doInsertQuery(Map<String, SqlQueryParameter> fields) { //TODO
        StringBuilder columns = new StringBuilder(" (");
        StringBuilder values = new StringBuilder("VALUES (");
        for (Map.Entry<String, SqlQueryParameter> entry : fields.entrySet()) {
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

    private void doDelete(Specification specification) throws RepositoryException {
        String sqlQuery = SqlConstant.DELETE_QUERY + getTableName() + " " + specification.toSqlRequest();
        try {
            PreparedStatement preparedStatement = setPreparedStatement(sqlQuery, specification);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new RepositoryException(exception.getMessage(), exception);
        }
    }

    private PreparedStatement setPreparedStatement(String sqlQuery, Specification specification) throws SQLException {
        int parametersLength = specification.receiveParameters().size();
        List<SqlQueryParameter> parameters = specification.receiveParameters();
        PreparedStatement statement = connection.prepareStatement(sqlQuery);
        for (int i = 0; i < parametersLength; i++) {
            switch (parameters.get(i).getType()) {
                case stringType:
                    statement.setString(i + 1, (String) parameters.get(i).getValue());
                    break;
                case intType:
                    statement.setInt(i + 1, (Integer) parameters.get(i).getValue());
                    break;
                case blobType:
                    statement.setBinaryStream(i + 1, (InputStream) parameters.get(i).getValue());
                    break;
                case doublePType:
                    statement.setDouble(i + 1, (Double) parameters.get(i).getValue());
                    break;
            }
        }
        return statement;
    }

    private PreparedStatement setInsertPreparedStatement(String sqlQuery, Map<String, SqlQueryParameter> fields) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
        int i = 1;
        for (Map.Entry<String, SqlQueryParameter> entry : fields.entrySet()) {
            SqlQueryParameter value = entry.getValue();
            switch (value.getType()) {
                case stringType:
                    statement.setString(i++, (String) value.getValue());
                    break;
                case intType:
                    statement.setInt(i++, (Integer) value.getValue());
                    break;
                case blobType:
                    statement.setBinaryStream(i++, (InputStream) value.getValue());
                    break;
                case doublePType:
                    statement.setDouble(i++, (Double) value.getValue());
                    break;
            }
        }
        return statement;
    }

    protected abstract List<T> toEntity(ResultSet resultSet) throws SQLException;

    protected abstract Map<String, SqlQueryParameter> toEntityFields(T t);

    protected abstract String getTableName();
}
