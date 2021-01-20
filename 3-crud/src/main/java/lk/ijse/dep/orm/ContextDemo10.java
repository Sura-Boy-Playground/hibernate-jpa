package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Customer;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/* 10 */
public class ContextDemo10 {

    public static void main(String[] args) {

        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {

            session.beginTransaction();

            Customer costa = new Customer(1, "Costa", "Galle");
            session.save(costa);
            Customer customer = session.get(Customer.class, 1);
            System.out.println("Before Commiting");

            session.getTransaction().commit();
        }
    }
}
