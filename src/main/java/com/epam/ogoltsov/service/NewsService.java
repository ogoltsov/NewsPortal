package com.epam.ogoltsov.service;

import com.epam.ogoltsov.dao.Dao;
import com.epam.ogoltsov.dao.DaoException;
import com.epam.ogoltsov.dao.DaoFactory;
import com.epam.ogoltsov.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

public class NewsService implements IService<News> {

    private static final String EMPTY_DAO_EXCEPTION = "Dao is empty";
    private static final String EMPTY_DAO_FACTORY_EXCEPTION = "DaoFactory is empty";
    private static final String FIND_ALL_EXCEPTION = "Can't findAll news";
    private static final String FIND_BY_ID_EXCEPTION = "Can't find news by id";
    private static final String SAVE_EXCEPTION = "Cant save news";
    private static final String DELETE_NEWS_EXCEPTION = "Can't delete news by id";
    private static final String INSERT_NEWS_EXCEPTION = "Can't insert news in DB";

    private Dao<News> dao;

    @Autowired
    private DaoFactory daoFactory;

    public Dao<News> getDao() {
        return dao;
    }

    public void setDao(Dao<News> dao) {
        this.dao = dao;
    }

    public DaoFactory getDaoFactory() {
        return daoFactory;
    }

    public void setDaoFactory(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Autowired
    public NewsService() throws ServiceException {
        DaoFactory daoFactory = DaoFactory.newInstance(DaoFactory.JDBC);
        if (daoFactory != null) {
            dao = daoFactory.createDao(News.class);
            if (dao == null) throw new ServiceException(EMPTY_DAO_EXCEPTION);
        } else throw new ServiceException(EMPTY_DAO_FACTORY_EXCEPTION);
    }

    @Override
    public List<News> findAll() throws ServiceException {
        try {
            return dao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(FIND_ALL_EXCEPTION, e);
        }
    }

    @Override
    public News findById(int id) throws ServiceException {
        try {
            return dao.findById(id);
        } catch (DaoException e) {
            throw new ServiceException(FIND_BY_ID_EXCEPTION, e);
        }
    }

    @Override
    public void save(News news) throws ServiceException {
        try {
            if (news.getId() != null) dao.update(news);
            else throw new DaoException("Entity error");
        } catch (DaoException e) {
            throw new ServiceException(SAVE_EXCEPTION, e);
        }
    }

    @Override
    public void delete(int id) throws ServiceException {
        try {
            dao.delete(id);
        } catch (DaoException e) {
            throw new ServiceException(DELETE_NEWS_EXCEPTION, e);
        }
    }

    @Override
    public News insert(News news) throws ServiceException {
        News newNews;
        try {
            newNews = dao.insert(news);
        } catch (DaoException e) {
            throw new ServiceException(INSERT_NEWS_EXCEPTION, e);
        }
        return newNews;
    }

    @Override
    public void close() throws Exception {
    }
}
