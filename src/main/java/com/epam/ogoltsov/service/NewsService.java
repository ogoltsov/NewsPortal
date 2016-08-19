package com.epam.ogoltsov.service;

import com.epam.ogoltsov.dao.Dao;
import com.epam.ogoltsov.dao.DaoException;
import com.epam.ogoltsov.model.News;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService implements IService<News> {

    private static final String EMPTY_DAO_EXCEPTION = "Dao is empty";
    private static final String EMPTY_DAO_FACTORY_EXCEPTION = "DaoFactory is empty";
    private static final String FIND_ALL_EXCEPTION = "Can't findAll news";
    private static final String FIND_BY_ID_EXCEPTION = "Can't find news by id";
    private static final String SAVE_EXCEPTION = "Cant save news";
    private static final String DELETE_NEWS_EXCEPTION = "Can't delete news by id";
    private static final String INSERT_NEWS_EXCEPTION = "Can't insert news in DB";

    private Dao<News> newsDao;

    public NewsService(Dao<News> newsDao) {
        this.newsDao = newsDao;
    }

    @Override
    public List<News> findAll() throws ServiceException {
        try {
            return newsDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(FIND_ALL_EXCEPTION, e);
        }
    }

    @Override
    public News findById(int id) throws ServiceException {
        try {
            return newsDao.findById(id);
        } catch (DaoException e) {
            throw new ServiceException(FIND_BY_ID_EXCEPTION, e);
        }
    }

    @Override
    public void save(News news) throws ServiceException {
        try {
            if (news.getId() != null) newsDao.update(news);
            else throw new DaoException("Entity error");
        } catch (DaoException e) {
            throw new ServiceException(SAVE_EXCEPTION, e);
        }
    }

    @Override
    public void delete(int id) throws ServiceException {
        try {
            newsDao.delete(id);
        } catch (DaoException e) {
            throw new ServiceException(DELETE_NEWS_EXCEPTION, e);
        }
    }

    @Override
    public News insert(News news) throws ServiceException {
        News newNews;
        try {
            newNews = newsDao.insert(news);
        } catch (DaoException e) {
            throw new ServiceException(INSERT_NEWS_EXCEPTION, e);
        }
        return newNews;
    }

    @Override
    public void close() throws Exception {
    }
}
