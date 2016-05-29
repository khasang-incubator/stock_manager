package io.khasang.stockmanager.dao;

import io.khasang.stockmanager.entity.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectDao {

    private String result;
    public void insertToTable(Project project){



    }

    public String getResult(){
        return "sucessfully insert to table";
    }
}
