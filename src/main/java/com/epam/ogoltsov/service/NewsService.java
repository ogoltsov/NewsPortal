package com.epam.ogoltsov.service;

import com.epam.ogoltsov.dao.Dao;
import com.epam.ogoltsov.dao.DaoException;
import com.epam.ogoltsov.model.News;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService implements IService<News> {

    private static final Logger log = LoggerFactory.getLogger(NewsService.class);

    private static final String FIND_ALL_EXCEPTION = "Can't findAll news";
    private static final String FIND_BY_ID_EXCEPTION = "Can't find news by id";
    private static final String SAVE_EXCEPTION = "Cant save news";
    private static final String DELETE_NEWS_EXCEPTION = "Can't delete news by id";
    private static final String INSERT_NEWS_EXCEPTION = "Can't insert news in DB";
    private static final String SERVICE_FIND_ALL = "Service findAll news";
    private static final String SERVICE_FIND_BY_ID = "Find news by id: ";
    private static final String SERVICE_SAVE_NEWS = "Save news: ";
    private static final String SERVICE_SAVE_EXCEPTION = "Can't save news with empty id";
    private static final String SERVICE_DELETE = "Delete news";
    private static final String SERVICE_DELETE_EXCEPTION = "Can't delete news id: ";
    private static final String SERVICE_INSERT = "Insert new news: ";
    private static final String SERVICE_INSERT_EXCEPTION = "Can't save news: ";

    private Dao<News> newsDao;

    public NewsService(Dao<News> newsDao) {
        this.newsDao = newsDao;
    }

    @Override
    public List<News> findAll() throws ServiceException {
        log.debug(SERVICE_FIND_ALL);
        try {
            return newsDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(FIND_ALL_EXCEPTION, e);
        }
    }

    @Override
    public News findById(int id) throws ServiceException {
        log.debug(SERVICE_FIND_BY_ID + id);
        try {
            return newsDao.findById(id);
        } catch (DaoException e) {
            throw new ServiceException(FIND_BY_ID_EXCEPTION, e);
        }
    }

    @Override
    public void save(News news) throws ServiceException {

        try {
            newsDao.update(news);
            log.debug(SERVICE_SAVE_NEWS + news);
        } catch (DaoException e) {
            log.debug(SAVE_EXCEPTION);
        }
    }

    @Override
    public void delete(int id) throws ServiceException {

        try {
            log.debug(SERVICE_DELETE);
            newsDao.delete(id);
        } catch (DaoException e) {
            log.error(SERVICE_DELETE_EXCEPTION + id);
            throw new ServiceException(DELETE_NEWS_EXCEPTION, e);
        }
    }

    @Override
    public News insert(News news) throws ServiceException {
        News newNews;
        try {
            log.debug(SERVICE_INSERT + news);
            newNews = newsDao.insert(news);
        } catch (DaoException e) {
            log.error(SERVICE_INSERT_EXCEPTION + news);
            throw new ServiceException(INSERT_NEWS_EXCEPTION, e);
        }
        return newNews;
    }

    @Override
    public void close() throws Exception {
    }
}
