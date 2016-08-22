package com.epam.ogoltsov.dao;

import com.epam.ogoltsov.model.News;
import com.epam.ogoltsov.pool.DBConnectionPool;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class NewsDaoImpl implements Dao<News> {


    private static final String INSERT_NEWS = "INSERT INTO NEWS_MANAGEMENT (TITLE, BRIEF, CONTENT, NEWS_DATE)  VALUES (?,?,?,TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS'))";
    private static final String FIND_BY_ID = "SELECT * FROM NEWS_MANAGEMENT WHERE ID = ?";
    private static final String SELECT_ALL = "SELECT  * FROM NEWS_MANAGEMENT ORDER BY NEWS_DATE";
    private static final String UPDATE_NEWS = "UPDATE NEWS_MANAGEMENT SET TITLE = ?, BRIEF = ?, CONTENT = ?, NEWS_DATE = TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS')  WHERE ID = ?";
    private static final String DELETE_NEWS = "DELETE FROM NEWS_MANAGEMENT WHERE ID = ?";
    private static final String DATE_PATTERN = "yyyy-MM-dd HH:MM:ss";

    private static final String ID = "id";
    private static final String TITLE = "title";
    private static final String BRIEF = "brief";
    private static final String DATE = "news_date";
    private static final String CONTENT = "content";

    @Override
    public News insert(News news) throws DaoException {
        try (Connection connection = DBConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT_NEWS, new String[]{ID})) {
            setObjectsToPreparedStatementExceptId(ps, news);
            ps.execute();

            news.setId(getIdFromResultSet(ps.getGeneratedKeys()));

        } catch (SQLException e) {
            throw new DaoException("", e);
        }
        return news;
    }

    private int getIdFromResultSet(ResultSet rs) throws SQLException {
        rs.next();
        return rs.getInt(1);
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
        News news;
        try (Connection connection = DBConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) news = getObjectFromResultSet(rs);
            else news = null;
        } catch (SQLException e) {
            throw new DaoException("", e);
        }
        return news;
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
        List<News> newses = new ArrayList<>();
        try (Connection connection = DBConnectionPool.getConnection();
             Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(SELECT_ALL);
            while (rs.next()) {
                newses.add(getObjectFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException("", e);
        }
        return newses;
    }

    private void setObjectsToPreparedStatement(PreparedStatement ps, News news) throws SQLException {
        setObjectsToPreparedStatementExceptId(ps, news);
        ps.setInt(5, news.getId());
    }

    @Override
    public void update(News news) throws DaoException {
        try (Connection connection = DBConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE_NEWS)) {
            setObjectsToPreparedStatement(ps, news);
            ps.execute();
        } catch (SQLException e) {
            throw new DaoException("", e);
        }
    }

    @Override
    public void delete(int id) throws DaoException {
        try (Connection connection = DBConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(DELETE_NEWS)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            throw new DaoException("", e);
        }
    }
}
