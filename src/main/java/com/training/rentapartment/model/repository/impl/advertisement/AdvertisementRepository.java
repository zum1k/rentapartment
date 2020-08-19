package com.training.rentapartment.model.repository.impl.advertisement;

import com.training.rentapartment.entity.Advertisement;
import com.training.rentapartment.model.repository.SqlConstant;
import com.training.rentapartment.model.pool.ConnectionPool;
import com.training.rentapartment.model.repository.impl.AbstractRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class AdvertisementRepository extends AbstractRepository<Advertisement> { //TODO
    private static final Logger LOGGER = LogManager.getLogger(AdvertisementRepository.class);

    public AdvertisementRepository() {
        super(ConnectionPool.getInstance().getConnection());
    }

    @Override
    protected List<Advertisement> toEntity(ResultSet resultSet) {
        List<Advertisement> advertisementList = null;
        try {
            advertisementList = new AdvertisementSqlMapper().toEntity(resultSet);
        } catch (SQLException exception) {
            LOGGER.error(exception.getMessage(), exception);
        }
        return advertisementList;
    }

    @Override
    protected Map<String, Object> toEntityFields(Advertisement advertisement) {
        return new AdvertisementSqlMapper().toEntityFields(advertisement);
    }

    @Override
    protected String getTableName() {
        return SqlConstant.ADVERTISEMENT_TABLE_NAME;
    }
}
