package io.khasang.stockmanager.model.pShtykov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

public class OuterJoin {

    @Autowired
    private Environment environment;

    private JdbcTemplate jdbcTemplate;

    public OuterJoin(JdbcTemplate jdbsTemplate) {
//        this.jdbsTemplate = jdbsTemplate;
    }

    public void outerJoin() {
        try {
            jdbcTemplate.execute("SELECT"
                    + ""
                    + "");
        } catch (Exception e) {
        }
    }

}
