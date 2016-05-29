package io.khasang.stockmanager.dao;

import io.khasang.stockmanager.entity.Offer;
import io.khasang.stockmanager.entity.Project;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class ProjectDao {
    @Autowired
    SessionFactory sessionFactory;
    private String result;
    public void insertToTable(Project project){

        Session session = sessionFactory.openSession();

//            session.beginTransaction();
//            String sql = "SELECT * FROM Project";
//            SQLQuery query = session.createSQLQuery(sql);
//            query.addEntity(Project.class);

        try {
            session.beginTransaction();

            //Receive status with specify id - required for check field state = at status end or not.
            List result = session.createCriteria(Project.class, "id")
                    .list();

            session.save(project);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            session.getTransaction().rollback();
          //  resultQuery = "fail: " + e;
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public String getResult(){
        return "sucessfully insert to table";
    }
}

