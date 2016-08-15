package com.epam.ogoltsov.dao;


import com.epam.ogoltsov.model.BaseEntity;

public class JdbcDaoFactory extends DaoFactory {

//    private final Connection connection;

    public JdbcDaoFactory() {
//        connection = DBConnectionPool.getConnection();
    }

    @Override
    public <T extends BaseEntity> Dao<T> createDao(Class<T> clazz) {
        switch (clazz.getSimpleName()) {
            case "News":
                return (Dao<T>) new NewsDaoImpl();
            default:
                return null;
        }
    }

    @Override
    public void close() throws DaoException {
//        if (connection != null) {
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                throw new DaoException("Failed to close factory", e);
//            }
//        }
    }

    @Override
    public void startTransaction() throws DaoException {
//        try {
//            connection.setAutoCommit(false);
//        } catch (SQLException e) {
//            throw new DaoException("Failed to setAutoCommit to false", e);
//        }
    }

    @Override
    public void finishTransaction() throws DaoException {
//        try {
//            connection.commit();
//            connection.setAutoCommit(true);
//        } catch (SQLException e) {
//            throw new DaoException("Failed to commit transaction", e);
//        }
    }

    @Override
    public void rollback() throws DaoException {
//        try {
//            connection.rollback();
//        } catch (SQLException e) {
//            throw new DaoException("Failed to rollback", e);
//        }
    }
}
