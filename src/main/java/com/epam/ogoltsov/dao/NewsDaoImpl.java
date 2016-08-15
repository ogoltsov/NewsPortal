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

public class NewsDaoImpl implements Dao<News> {

    private static final String INSERT_NEWS = "INSERT INTO news (title, brief, content)  VALUES (?,?,?)";
    private static final String FIND_BY_ID = "SELECT * FROM news WHERE id = ?";
    private static final String SELECT_ALL = "SELECT  * FROM news ORDER BY DATE";
    private static final String UPDATE_NEWS = "UPDATE news SET title = ?, brief = ?, DATE = ?, content = ? WHERE id = ?;";
    private static final String DELETE_NEWS = "DELETE FROM news WHERE id = ?";

    NewsDaoImpl() {
    }

    @Override
    public void insert(News news) throws DaoException {
        try (Connection connection = DBConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT_NEWS)) {
            ps.setString(1, news.getTitle());
            ps.setString(2, news.getBrief());
            ps.setString(3, news.getContent());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException("", e);
        }
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
            e.printStackTrace();
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

    @Override
    public void update(News news) throws DaoException {
        try (Connection connection = DBConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE_NEWS)) {
            ps.setString(1, news.getTitle());
            ps.setString(2, news.getBrief());
            ps.setString(3, LocalDateTime.of(news.getDate(),
                    LocalTime.now()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:MM:SS")));
            ps.setString(4, news.getContent());
            ps.setInt(5, news.getId());
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
