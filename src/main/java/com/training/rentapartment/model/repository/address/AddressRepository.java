package com.training.rentapartment.model.repository.address;

import com.training.rentapartment.entity.Address;
import com.training.rentapartment.model.Repository;
import com.training.rentapartment.model.SqlConstant;
import com.training.rentapartment.model.pool.ConnectionPool;
import com.training.rentapartment.model.repository.AbstractRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class AddressRepository extends AbstractRepository<Address> {
    private static final Logger LOGGER = LogManager.getLogger(AddressRepository.class);

    public AddressRepository() {
        super(ConnectionPool.getINSTANCE().getConnection());
    }

    @Override
    protected List<Address> toEntity(ResultSet resultSet) throws SQLException {
        return new AddressMapperImpl().toEntity(resultSet);
    }

    @Override
    protected Map<String, Object> toEntityFields(Address address) {
        return new AddressMapperImpl().toEntityFields(address);
    }

    @Override
    protected String getTableName() {
        return SqlConstant.ADDRESS_TABLE_NAME;
    }

}
