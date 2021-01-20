package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Customer;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EagarLazyDemo {

    public static void main(String[] args) {

        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {

            session.beginTransaction();

            Customer nuwan = session.get(Customer.class, 2);
            session.evict(nuwan);
            Customer clonedNuwan = (Customer) session.merge(nuwan);
            System.out.println("Let's change the nuwan's address");
            clonedNuwan.setAddress("Galle");
            System.out.println("We finished updating");
            session.getTransaction().commit();
        }
    }
}
