package io.khasang.stockmanager.dao;

import io.khasang.stockmanager.model.Subject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SubjectDAO {
    private JdbcTemplate jdbcTemplate;

    public SubjectDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Subject> getSubjects() {
        String sql = "" +
                "SELECT * " +
                "FROM   subjects;";
        return jdbcTemplate.query(sql, new SubjectRowMapper());
    }

    private static final class SubjectRowMapper implements RowMapper<Subject> {
        @Override
        public Subject mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Subject(
                    resultSet.getInt("id"),
                    resultSet.getString("subject"),
                    resultSet.getString("location")
            );
        }
    }
}
