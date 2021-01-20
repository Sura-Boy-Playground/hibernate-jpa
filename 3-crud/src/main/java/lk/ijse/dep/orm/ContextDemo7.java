package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Customer;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/* 7 */
public class ContextDemo7 {

    public static void main(String[] args) {

        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {

            session.beginTransaction();

            Customer customer = session.get(Customer.class, 1);
            session.detach(customer);
            session.remove(customer);

            session.getTransaction().commit();
        }
    }
}
