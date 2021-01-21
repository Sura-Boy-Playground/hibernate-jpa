package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Customer;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/* 10 */
public class ContextDemo13 {

    public static void main(String[] args) {

        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {

            session.beginTransaction();

            Customer sajeewa = session.get(Customer.class, 2);
            System.out.println(session.contains(sajeewa));
            session.evict(sajeewa);
            System.out.println("After Evict");
            System.out.println(session.contains(sajeewa));
            session.refresh(sajeewa);
            System.out.println("After Refresh");
            System.out.println(session.contains(sajeewa));

            session.getTransaction().commit();
        }
    }
}
