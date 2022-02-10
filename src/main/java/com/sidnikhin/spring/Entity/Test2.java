package com.sidnikhin.spring.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try{
            Session session=factory.getCurrentSession();
            Employee emp=new Employee("Galya","Petrovich","HR",28);
            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();

            int myId =emp.getId();//начало получения записи
            session=factory.getCurrentSession();//обращение к сессии
            session.beginTransaction();//открытие транзакции
            Employee employee=session.get(Employee.class,myId);// "SELECT"
            session.getTransaction().commit();//Закрытие транзакции
            System.out.println("ID="+myId);
            System.out.println(employee);
        }
        finally
        {
            factory.close();
        }
    }
}
