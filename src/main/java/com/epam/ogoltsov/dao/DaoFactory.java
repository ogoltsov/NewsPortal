package com.epam.ogoltsov.dao;


import com.epam.ogoltsov.model.BaseEntity;

public abstract class DaoFactory implements AutoCloseable {
    public static final int JDBC = 1;

    public static DaoFactory newInstance(int whichFactory) {
        switch (whichFactory) {
            case JDBC:
                return new JdbcDaoFactory();
            default:
                return null;
        }
    }

    public abstract <T extends BaseEntity>  Dao<T> createDao(Class<T> clazz);

    @Override
    public void close() throws Exception {   }
}
