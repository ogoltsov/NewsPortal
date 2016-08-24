package com.epam.ogoltsov.dao;

import com.epam.ogoltsov.model.News;
import com.epam.ogoltsov.pool.DBConnectionPool;

import javax.persistence.EntityManager;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class NewsDaoImpl implements Dao<News> {

    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private static final String DATE_PATTERN = "yyyy-MM-dd HH:MM:ss";

    private static final String ID = "id";
    private static final String TITLE = "title";
    private static final String BRIEF = "brief";
    private static final String DATE = "news_date";
    private static final String CONTENT = "content";

    @Override
    public News insert(News news) throws DaoException {
        return entityManager.merge(news);

    }

    private void setObjectsToPreparedStatementExceptId(PreparedStatement ps, News news) throws SQLException {
        ps.setString(1, news.getTitle());
        ps.setString(2, news.getBrief());
        ps.setString(3, news.getContent());
        ps.setString(4, getDateFromObject(news));
    }

    private String getDateFromObject(News news) {
        return LocalDateTime.of(news.getDate(),
                LocalTime.now()).format(DateTimeFormatter.ofPattern(DATE_PATTERN));
    }

    @Override
    public News findById(int id) throws DaoException {
        return entityManager.find(News.class, id);
    }

    private News getObjectFromResultSet(ResultSet rs) throws SQLException {
        News news = new News();

        news.setId(rs.getInt(ID));
        news.setTitle(rs.getString(TITLE));
        news.setBrief(rs.getString(BRIEF));
        news.setDate(LocalDate.from(rs.getTimestamp(DATE).toLocalDateTime()));
        news.setContent(rs.getString(CONTENT));

        return news;
    }

    @Override
    public List<News> findAll() throws DaoException {
        return null;
    }

    private void setObjectsToPreparedStatement(PreparedStatement ps, News news) throws SQLException {
        setObjectsToPreparedStatementExceptId(ps, news);
        ps.setInt(5, news.getId());
    }

    @Override
    public void update(News news) throws DaoException {

    }

    @Override
    public void delete(int id) throws DaoException {

    }
}
