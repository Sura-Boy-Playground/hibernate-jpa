package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Customer;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MergeDemo2 {

    public static void main(String[] args) {

        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {

            session.beginTransaction();

            Customer nuwan = session.get(Customer.class, 2);
            session.evict(nuwan);
            Customer nuwanAgain = session.get(Customer.class, 2);
            System.out.println("Before merging");
            session.merge(nuwan);
            System.out.println("After merging");

            session.getTransaction().commit();
        }
    }
}
