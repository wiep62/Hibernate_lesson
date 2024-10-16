package com.skillbox.hibernate.first;

import com.skillbox.hibernate.mToM.Reader;
import com.skillbox.hibernate.manyToOne.University;
import com.skillbox.hibernate.oneToOne.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    private static SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

    public static void main(String[] args) {
        Session session = sessionFactory.getCurrentSession();
        try {

            session.getTransaction().begin();
            Reader reader = session.get(Reader.class, 1L); //ОБЪЕКТ ЕСТЬ В ПАМЯТИ, ССЫЛКА НА НЕГО НЕ ПРОПОДАЛА
            System.out.println(reader.getBooks()); //сколько книг прочитал читатель
            session.getTransaction().commit();
            session.close();


/*//ДОСТАЕМ СТУДИКОВ:
            session.getTransaction().begin();
            University university = session.get(University.class, 1L); //ОБЪЕКТ ЕСТЬ В ПАМЯТИ, ССЫЛКА НА НЕГО НЕ ПРОПОДАЛА
            System.out.println(university.getStudents());
            System.out.println(university.getTitle());

            session.getTransaction().commit();
            session.close();*/


/*
            session.getTransaction().begin();
            University university = session.get(University.class, 1L); //ОБЪЕКТ ЕСТЬ В ПАМЯТИ, ССЫЛКА НА НЕГО НЕ ПРОПОДАЛА
        //    System.out.println(university.getStudents());
            session.getTransaction().commit();
            session.close();

            System.out.println(university.getStudents()); //TODO СТУДЕНТОВ ДОСТАТЬ НЕ ПОЛУЧИЛОСЬ,
            System.out.println(university.getTitle()); //TODO СПИСОК УНИВЕРОВ ВЫВОДИТСЯ
*/

  /*
          1 2 м
          session.getTransaction().begin();
            University university = session.get(University.class, 1L);
            System.out.println(university.getStudents());
            session.getTransaction().commit();
            session.close();
*/
/*//todo 1 two 1:
            session.getTransaction().begin();
            Employee userOne = session.get(Employee.class, 3L);
            System.out.println(userOne.getDetails());
            session.getTransaction().commit();
            session.close();*/

/*
            session = sessionFactory.getCurrentSession();
            session.getTransaction().begin();
            User user = session.get(User.class, 3L);
            System.out.println(user);
            session.getTransaction().commit();
            session.close();
*/



            //   session.getTransaction().begin();
   //         Reader reader = session.get(Reader.class, 1L);

//            System.out.println(reader.getBooks());
  //          session.getTransaction().commit();
    //        session.close();

//            System.out.println(university.getTitle());
//            System.out.println(university.getStudents());


           // session = sessionFactory.getCurrentSession();
      /**     session.getTransaction().begin();
            User userOne = session.get(User.class, 3L);
            userOne.setName("Frank");
            session.getTransaction().commit();
            session.close();

            session = sessionFactory.getCurrentSession();
            session.getTransaction().begin();
           // User user = new User("Jony");

            User user = session.get(User.class, 3L);

            session.save(user);
            session.getTransaction().commit();
            System.out.println(user);
*/
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
