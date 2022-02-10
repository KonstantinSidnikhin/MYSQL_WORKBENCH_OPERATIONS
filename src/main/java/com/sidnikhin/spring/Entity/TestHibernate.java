package com.sidnikhin.spring.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class TestHibernate {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try{
            Session session=factory.getCurrentSession();
            session.beginTransaction();
//            List <Employee> emps=session.createQuery("from Employee")
//                            .getResultList();//получение всех работников из листа
            List <Employee> emps=session.createQuery("from Employee WHERE name='John' AND salary>2000")
                          .getResultList();
            for(Employee e:emps){
                System.out.println(e);
            }
            session.getTransaction().commit();

        }
        finally
            {
                factory.close();
            }
        }
    }

