package io.khasang.stockmanager.dao;

import io.khasang.stockmanager.model.Author;
import io.khasang.stockmanager.model.Book;
import io.khasang.stockmanager.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BookDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AuthorDAO authorDAO;
    @Autowired
    private SubjectDAO subjectDAO;

    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getAllBooks() {
        String sql = "" +
                "SELECT * " +
                "FROM books;";
        return jdbcTemplate.query(sql, new BookRowMapper());
    }

    private Author getAuthor(int id) {
        List<Author> authors = authorDAO.getAllAuthors();
        for (Author author : authors) {
            if (author.getId().equals(id)) {
                return author;
            }
        }
        throw new RuntimeException("Author not found");
    }

    private Subject getSubject(int id) {
        List<Subject> subjects = subjectDAO.getSubjects();
        for (Subject subject : subjects) {
            if (subject.getId().equals(id)) {
                return subject;
            }
        }
        throw new RuntimeException("Subject not found");
    }

    private final class BookRowMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Book(
                    resultSet.getInt("id"),
                    resultSet.getString("title"),
                    getAuthor(resultSet.getInt("author_id")),
                    getSubject(resultSet.getInt("subject_id"))
            );
        }
    }
}
