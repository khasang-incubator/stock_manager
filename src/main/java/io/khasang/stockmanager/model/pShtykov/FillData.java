package io.khasang.stockmanager.model.pShtykov;

import io.khasang.stockmanager.model.pShtykov.datalanguage.Dml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FillData {

    @Autowired
    private Dml dml;

    private boolean result;

    public FillData() {
    }

    public void fill() {
        result = (dml.insert(createDataTableOne()) & dml.insert(createDataTableTwo()));
    }

    private String createDataTableOne() {
        String query = "";
        query += "INSERT INTO table_one (employee, room)  VALUES ('Peter', 101);";
        query += "INSERT INTO table_one (employee, room)  VALUES ('Alex', 102);";
        query += "INSERT INTO table_one (employee, room)  VALUES ('Eugen', 103);";
        query += "INSERT INTO table_one (employee, room)  VALUES ('Kate', 101);";
        query += "INSERT INTO table_one (employee, room)  VALUES ('Olga', 102);";
        query += "INSERT INTO table_one (employee, room)  VALUES ('Clare', 103);";
        query += "INSERT INTO table_one (employee, room)  VALUES ('Sasha', 201);";
        query += "INSERT INTO table_one (employee, room)  VALUES ('Dasha', 202);";
        query += "INSERT INTO table_one (employee, room)  VALUES ('Natasha', 203);";
        return query;
    }

    private String createDataTableTwo() {
        String query = "";
        query += "INSERT INTO table_two (room, department)  VALUES (101, 'IT');";
        query += "INSERT INTO table_two (room, department)  VALUES (102, 'Managers');";
        query += "INSERT INTO table_two (room, department)  VALUES (103, 'Logistics');";
        query += "INSERT INTO table_two (room, department)  VALUES (150, 'Cafe');";
        query += "INSERT INTO table_two (room, department)  VALUES (160, 'Insurance');";
        return query;
    }

    @Bean
    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
