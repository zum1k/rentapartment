package com.training.rentapartment.model.repository;

import com.training.rentapartment.entity.Address;
import com.training.rentapartment.model.Repository;
import com.training.rentapartment.model.Specification;
import com.training.rentapartment.model.SqlConstant;
import com.training.rentapartment.model.repository.address.AddressMapperImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class AbstractRepository<T> implements Repository<T>, Cloneable, AutoCloseable {
    private static final String SELECT_QUERY = "SELECT * FROM ";
    private static final String DELETE_QUERY = "DELETE FROM ";

    private Connection connection;

    public AbstractRepository(Connection connection) {
        this.connection = connection;
    }
    @Override
    public void add(T t) {
    }

    @Override
    public void remove(Specification specification) {
    }

    @Override
    public List<T> query(Specification specification) {
        return null;
    }

    @Override
    public Optional<T> singleQuery(Specification specification) {
        return Optional.empty();
    }

    @Override
    public void close() throws Exception {

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
    private void doAdd(T t) { //TODO
        try {
            Map<String, Object> fields = toEntityFields(t);
            String sql = SqlConstant.INSERT_QUERY + SqlConstant.ADDRESS_TABLE_NAME + doInsertQuery(fields);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int i = 1;
            for (Map.Entry<String, Object> entry : fields.entrySet()) {
                Object value = entry.getValue();
                preparedStatement.setString(i++, String.valueOf(value));
            }
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {


        }
    }

    private List<T> toEntity(ResultSet resultSet) throws SQLException{
        return null;
    }
    private Map<String, Object> toEntityFields(T t){
        return null;
    }
}
