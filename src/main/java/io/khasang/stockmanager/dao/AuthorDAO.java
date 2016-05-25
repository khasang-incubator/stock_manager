package io.khasang.stockmanager.dao;

import io.khasang.stockmanager.model.Author;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AuthorDAO {
    private JdbcTemplate jdbcTemplate;

    public AuthorDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Author findAuthorById(int id) {
        String sql = "" +
                "SELECT * " +
                "FROM   authors " +
                "WHERE  id = ?;";
        return jdbcTemplate.queryForObject(sql, new AuthorRowMapper(), id);
    }

    public List<Author> getAllAuthors() {
        String sql = "" +
                "SELECT * " +
                "FROM   authors;";
        return jdbcTemplate.query(sql, new AuthorRowMapper());
    }

    public Author updateAuthorName() {
        String sql = "" +
                "UPDATE authors " +
                "SET    last_name = 'sdfgdfg' " +
                "WHERE  id = 15990";
        jdbcTemplate.update(sql);
        return findAuthorById(15990);
    }

    public List<Author> deleteFirstTenRows() {
        String sql = "" +
                "DELETE FROM authors " +
                "WHERE  ctid IN (" +
                "   SELECT  ctid " +
                "   FROM    authors " +
                "   LIMIT   10" +
                ");";
        jdbcTemplate.update(sql);
        return getAllAuthors();
    }

    public String truncate() {
        String sql = "TRUNCATE authors;";
        jdbcTemplate.update(sql);
        return "All rows has been deleted";
    }

    public String createTable() {
        String sql = "" +
                "CREATE TABLE IF NOT EXISTS authors (" +
                "   id          INTEGER NOT NULL, " +
                "   last_name   TEXT, " +
                "   first_name  TEXT, " +
                "   CONSTRAINT authors_pkey PRIMARY KEY (id) " +
                ");";
        jdbcTemplate.execute(sql);
        return "Table created successful";
    }

    private static final class AuthorRowMapper implements RowMapper<Author> {
        @Override
        public Author mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Author(
                    resultSet.getInt("id"),
                    resultSet.getString("last_name"),
                    resultSet.getString("first_name")
            );
        }
    }
}
