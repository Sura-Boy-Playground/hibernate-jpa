package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Customer;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ContextDemo {

    public static void main(String[] args) {

        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {

            session.beginTransaction();

            Customer costa = new Customer(2, "Costa", "Galkissa");
            session.save(costa);
            Customer salitha = session.get(Customer.class, 1);

            session.getTransaction().commit();
        }
    }
}
