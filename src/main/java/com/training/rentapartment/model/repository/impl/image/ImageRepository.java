package com.training.rentapartment.model.repository.impl.image;

import com.training.rentapartment.entity.Image;
import com.training.rentapartment.model.repository.SqlConstant;
import com.training.rentapartment.model.pool.ConnectionPool;
import com.training.rentapartment.model.repository.impl.AbstractRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ImageRepository extends AbstractRepository<Image> {
    private static final Logger LOGGER = LogManager.getLogger(ImageRepository.class);

    public ImageRepository() {
        super(ConnectionPool.getInstance().getConnection());
    }

    @Override
    protected List<Image> toEntity(ResultSet resultSet) {
        List<Image> imageList = null;
        try {
            imageList = new ImageSqlMapper().toEntity(resultSet);
        } catch (SQLException exception) {
            LOGGER.error(exception.getMessage(), exception);
        }
        return imageList;
    }

    @Override
    protected Map<String, Object> toEntityFields(Image image) {
        return new ImageSqlMapper().toEntityFields(image);
    }

    @Override
    protected String getTableName() {
        return SqlConstant.IMAGES_TABLE_NAME;
    }
}
