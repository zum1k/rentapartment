package com.training.rentapartment.model.repository.image;

import com.training.rentapartment.entity.Image;
import com.training.rentapartment.model.SqlConstant;
import com.training.rentapartment.model.pool.ConnectionPool;
import com.training.rentapartment.model.repository.AbstractRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ImageRepository extends AbstractRepository<Image> {
    private static final Logger LOGGER = LogManager.getLogger(ImageRepository.class);

    public ImageRepository() {
        super(ConnectionPool.getINSTANCE().getConnection());
    }

    @Override
    protected List<Image> toEntity(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    protected Map<String, Object> toEntityFields(Image image) {
        return null;
    }

    @Override
    protected String getTableName() {
        return SqlConstant.IMAGES_TABLE_NAME;
    }
}
