package com.epam.ogoltsov.service;

import com.epam.ogoltsov.dao.Dao;
import com.epam.ogoltsov.dao.DaoException;
import com.epam.ogoltsov.dao.DaoFactory;
import com.epam.ogoltsov.model.News;
import com.epam.ogoltsov.pool.DBConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class NewsService implements IService<News> {

    private Dao<News> dao;

    public NewsService() {
        DaoFactory daoFactory = DaoFactory.newInstance(DaoFactory.JDBC);
        if (daoFactory != null) {
            dao = daoFactory.createDao(News.class);
            if (dao == null) throw new ServiceException("NewsDao is empty");
        } else throw new ServiceException("DaoFactory is empty");
    }

    @Override
    public List<News> findAll() throws ServiceException {
        try {
            return dao.findAll();
        } catch (DaoException e) {
            throw new ServiceException("",e );
        }
    }

    @Override
    public News findById(int id) throws ServiceException {
        try {
            return dao.findById(id);
        } catch (DaoException e) {
            throw new ServiceException("");
        }
    }

    @Override
    public void save(News news) {
        try {
            if (news.getId() != null) dao.update(news);
            else throw new DaoException("Entity error");
        } catch (DaoException e) {
            throw new ServiceException("", e);
        }
    }

    @Override
    public void delete(int id) {
        try {
           dao.delete(id);
        } catch (DaoException e) {
            throw new ServiceException("", e);
        }
    }

    @Override
    public News insert(News news) {
        News newNews;
        try  {
            newNews = dao.insert(news);
        } catch (DaoException e) {
            throw new ServiceException("", e);
        }
        return newNews;
    }

    @Override
    public void close() throws Exception {}
}
