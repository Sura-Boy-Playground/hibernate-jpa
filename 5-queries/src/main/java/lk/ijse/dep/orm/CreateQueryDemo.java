package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Customer;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class CreateQueryDemo {

    public static void main(String[] args) {

        try(SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession()){
            session.beginTransaction();

            List<Customer> customers = session.
                    createQuery("SELECT c FROM Customer c").list();
            customers.forEach(System.out::println);

            List<Customer> customers2 = session.
                    createQuery("SELECT c FROM Customer c", Customer.class).list();
            customers2.forEach(System.out::println);

            session.getTransaction().commit();
        }
    }
}
