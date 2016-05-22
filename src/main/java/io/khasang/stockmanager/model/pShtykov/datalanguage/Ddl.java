package io.khasang.stockmanager.model.pShtykov.datalanguage;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@Scope("prototype")
public class Ddl {

    @Autowired
    Environment environment;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private boolean result;

    public Ddl() {
    }

    public Ddl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean query(String query) {
        PreparedStatement ps = null;
        try {
            ps = jdbcTemplate.getDataSource().getConnection().prepareStatement(query);
            ps.execute();
            result = true;
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
            return result;
        } finally {
            try {
                ps.close();
                jdbcTemplate.getDataSource().getConnection().close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
