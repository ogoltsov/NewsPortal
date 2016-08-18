package com.epam.ogoltsov.dao;

import com.epam.ogoltsov.model.BaseEntity;
import com.epam.ogoltsov.servlet.SpringContextSingleton;

public class JdbcDaoFactory extends DaoFactory {

    public JdbcDaoFactory() {
        super();
    }

    @Override
    public <T extends BaseEntity> Dao<T> createDao(Class<T> clazz) {
        switch (clazz.getSimpleName()) {
            case "News":
//                return (Dao<T>) new NewsDaoImpl();
            return (Dao<T>) SpringContextSingleton.getContext().getBean("newsDao", NewsDaoImpl.class);
            default:
                return null;
        }
    }

}
