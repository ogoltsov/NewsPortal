package com.epam.ogoltsov.dao;


import com.epam.ogoltsov.model.BaseEntity;

public class JdbcDaoFactory extends DaoFactory {

    @Override
    public <T extends BaseEntity> Dao<T> createDao(Class<T> clazz) {
        switch (clazz.getSimpleName()) {
            case "News":
                return (Dao<T>) new NewsDaoImpl();
            default:
                return null;
        }
    }

}
