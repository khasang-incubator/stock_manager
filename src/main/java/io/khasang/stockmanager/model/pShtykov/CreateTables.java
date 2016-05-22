package io.khasang.stockmanager.model.pShtykov;

import io.khasang.stockmanager.model.pShtykov.datalanguage.Ddl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateTables {

    @Autowired
    Environment environment;

    @Autowired
    private Ddl ddl;

    @Autowired
    private FillData fillData;

    @Autowired
    private Select select;

    private boolean result;

    public CreateTables() {
    }

    @PostConstruct
    public void create() {
        result = (dropTableOne() & dropTableTwo() & createTableOne() & createTableTwo());
        if (result) {
            fillData.fill();
            select.select();
        }
    }

    private boolean dropTableOne() {
        String query = "DROP TABLE IF EXISTS table_one;";
        return ddl.query(query);
    }

    private boolean dropTableTwo() {
        String query = "DROP TABLE IF EXISTS table_two;";
        return ddl.query(query);
    }

    private boolean createTableOne() {
        String query = "CREATE TABLE table_one "
                + "(ID  SERIAL PRIMARY KEY, "
                + "employee TEXT NOT NULL, "
                + "room INT NOT NULL);";
        return ddl.query(query);
    }

    private boolean createTableTwo() {
        String query = "CREATE TABLE table_two "
                + "(ID  SERIAL PRIMARY KEY, "
                + "room INT NOT NULL, "
                + "department TEXT NOT NULL);";
        return ddl.query(query);
    }

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

}
