package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    private static SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();
    public static void main(String[] args) {
 Session session = sessionFactory.getCurrentSession();
 try {
     session.getTransaction().begin();
     session.getTransaction().commit();
 }catch (Exception e){
     e.printStackTrace();
 }finally {
     session.close();
 }

        }
}