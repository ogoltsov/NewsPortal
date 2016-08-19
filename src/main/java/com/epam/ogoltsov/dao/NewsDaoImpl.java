package com.epam.ogoltsov.dao;

import com.epam.ogoltsov.model.News;
import com.epam.ogoltsov.pool.DBConnectionPool;
import com.epam.ogoltsov.servlet.SpringContextSingleton;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class NewsDaoImpl implements Dao<News> {


    private static final String INSERT_NEWS = "INSERT INTO news (title, brief, content, DATE)  VALUES (?,?,?,?)";
    private static final String FIND_BY_ID = "SELECT * FROM news WHERE id = ?";
    private static final String SELECT_ALL = "SELECT  * FROM news ORDER BY DATE";
    private static final String UPDATE_NEWS = "UPDATE news SET title = ?, brief = ?, content = ?, DATE = ?  WHERE id = ?;";
    private static final String DELETE_NEWS = "DELETE FROM news WHERE id = ?";

    @Override
    public News insert(News news) throws DaoException {
        try (Connection connection = DBConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT_NEWS, PreparedStatement.RETURN_GENERATED_KEYS)) {
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
                LocalTime.now()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:MM:ss"));
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

        news.setId(rs.getInt("id"));
        news.setTitle(rs.getString("title"));
        news.setBrief(rs.getString("brief"));
        news.setDate(LocalDate.from(rs.getTimestamp("date").toLocalDateTime()));
        news.setContent(rs.getString("content"));

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
