package com.epam.ogoltsov.dao;

import com.epam.ogoltsov.model.News;
import com.epam.ogoltsov.pool.DBConnectionPool;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class NewsDaoImpl implements Dao<News> {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private static final String DATE_PATTERN = "yyyy-MM-dd HH:MM:ss";

    private static final String ID = "id";
    private static final String TITLE = "title";
    private static final String BRIEF = "brief";
    private static final String DATE = "news_date";
    private static final String CONTENT = "content";

    @Override
    public News insert(News news) throws DaoException {


        return null;

    }

    @Override
    public News findById(int id) throws DaoException {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        News news = currentSession.get(News.class, id);
        currentSession.getTransaction().commit();
        return news;
    }

    @Override
    public List<News> findAll() throws DaoException {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        List list = sessionFactory.getCurrentSession()
                .createCriteria(News.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
        currentSession.getTransaction().commit();
        return list;
    }

    @Override
    public void update(News news) throws DaoException {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        currentSession.saveOrUpdate(news);
        currentSession.getTransaction().commit();
    }

    @Override
    public void delete(int id) throws DaoException {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        News news = currentSession.get(News.class, id);
        currentSession.delete(news);
        currentSession.getTransaction().commit();
    }
}
