package io.khasang.stockmanager.model.pShtykov;

import io.khasang.stockmanager.model.pShtykov.datalanguage.Ddl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
    private SelectEmployees select;

    @Autowired
    private OuterJoin outerJoin;

    private boolean result;

    public CreateTables() {
    }

    public void create() {
        result = (dropTableEmployees() & dropTableDepartments() & createTableEmployees() & createTableDepartments());
    }

    private boolean dropTableEmployees() {
        String query = "DROP TABLE IF EXISTS employees;";
        return ddl.query(query);
    }

    private boolean dropTableDepartments() {
        String query = "DROP TABLE IF EXISTS departments;";
        return ddl.query(query);
    }

    private boolean createTableEmployees() {
        String query = "CREATE TABLE employees "
                + "(ID  SERIAL PRIMARY KEY, "
                + "employee TEXT NOT NULL, "
                + "room INT NOT NULL);";
        return ddl.query(query);
    }

    private boolean createTableDepartments() {
        String query = "CREATE TABLE departments "
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
