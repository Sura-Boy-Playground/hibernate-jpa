package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Customer;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class NamedQueryDemo {

    public static void main(String[] args) {

        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            session.beginTransaction();

            List<Customer> query1 = session.getNamedQuery("query1").list();
            query1.forEach(System.out::println);

            System.out.println("------------------------");

            List<Customer> query2 = session.createNamedQuery("query2", Customer.class).
                    setParameter(1, "C%").list();
            query2.forEach(System.out::println);

            session.getTransaction().commit();
        }
    }
}
