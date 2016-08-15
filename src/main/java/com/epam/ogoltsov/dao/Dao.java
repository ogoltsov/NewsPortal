package com.epam.ogoltsov.dao;

import java.util.List;

public interface Dao<T> {

    T insert(T t) throws DaoException;

    T findById(int id) throws DaoException;

    List<T> findAll() throws DaoException;

    void update(T t) throws DaoException;

    void delete(int id) throws DaoException;
}
