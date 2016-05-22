package io.khasang.stockmanager.model.pShtykov.datalanguage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@Scope("prototype")
public class Dml {

    @Autowired
    Environment environment;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Dml() {
    }

    public Dml(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Object selectOrUpdate(String query) {
        PreparedStatement ps = null;
        try {
            ps = jdbcTemplate.getDataSource().getConnection().prepareStatement(query);
            boolean result = ps.execute();
            if (result) {
                return ps.executeQuery();
            } else {
                return ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                jdbcTemplate.getDataSource().getConnection().close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public boolean insert(String query) {
        PreparedStatement ps = null;
        try {
            ps = jdbcTemplate.getDataSource().getConnection().prepareStatement(query);
            ps.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                jdbcTemplate.getDataSource().getConnection().close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
