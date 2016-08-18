package com.epam.ogoltsov.dao;

import com.epam.ogoltsov.model.BaseEntity;
import com.epam.ogoltsov.servlet.SpringContextSingleton;
import org.springframework.stereotype.Component;

public abstract class DaoFactory implements AutoCloseable {
    public static final int JDBC = 1;

    public DaoFactory() {
    }

    public static DaoFactory newInstance(int whichFactory) {
        switch (whichFactory) {
            case JDBC:
                return SpringContextSingleton.getContext().getBean("jdbcDaoFactory", JdbcDaoFactory.class);
            default:
                return null;
        }
    }

    public abstract <T extends BaseEntity> Dao<T> createDao(Class<T> clazz);

    @Override
    public void close() throws Exception {
    }
}
