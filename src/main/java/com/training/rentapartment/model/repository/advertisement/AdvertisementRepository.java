package com.training.rentapartment.model.repository.advertisement;

import com.training.rentapartment.entity.Advertisement;
import com.training.rentapartment.entity.Image;
import com.training.rentapartment.model.Repository;
import com.training.rentapartment.model.Specification;
import com.training.rentapartment.model.SqlConstant;
import com.training.rentapartment.model.pool.ConnectionPool;
import com.training.rentapartment.model.repository.AbstractRepository;
import com.training.rentapartment.model.repository.image.ImageMapperImpl;
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

public class AdvertisementRepository extends AbstractRepository<Advertisement>  { //TODO
    private static final Logger LOGGER = LogManager.getLogger(AdvertisementRepository.class);

    public AdvertisementRepository(){
        super(ConnectionPool.getINSTANCE().getConnection());
    }

    @Override
    protected List<Advertisement> toEntity(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    protected Map<String, Object> toEntityFields(Advertisement advertisement) {
        return null;
    }

    @Override
    protected String getTableName() {
        return SqlConstant.ADVERTISEMENT_TABLE_NAME;
    }
}
