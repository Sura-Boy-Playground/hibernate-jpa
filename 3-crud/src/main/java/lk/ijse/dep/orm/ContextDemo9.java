package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Customer;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/* 9 */
public class ContextDemo9 {

    public static void main(String[] args) {

        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {

            session.beginTransaction();

            Customer customer = new Customer(1, "Kasun", "Galle");
            session.save(customer);
//            session.detach(customer);
//            session.merge(customer);

            session.getTransaction().commit();
        }
    }
}
