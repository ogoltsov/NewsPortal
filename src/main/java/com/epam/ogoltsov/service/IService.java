package com.epam.ogoltsov.service;

import java.util.List;

public interface IService<T> extends AutoCloseable {

    List<T> findAll() throws ServiceException;

    T findById(int id) throws ServiceException;

    void save(T t);

    void delete(int id);

    T insert(T t);
}
