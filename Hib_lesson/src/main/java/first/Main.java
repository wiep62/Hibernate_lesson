package first;

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

     User user = session.get(User.class, 1L);
     System.out.println(user);
     session.getTransaction().commit();
 }catch (Exception e){
     e.printStackTrace();
 }finally {
     session.close();
 }

        }
}