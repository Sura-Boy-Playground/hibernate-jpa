package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Customer;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/* Anjamikai */
public class RefreshDemo1 {

    public static void main(String[] args) {

        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {

            session.beginTransaction();

            Customer nuwan = session.get(Customer.class, 2);
//            Customer nuwan = new Customer(2, "Kasun", "Galle");
            nuwan.setAddress("Galkissa");
            session.evict(nuwan);
            System.out.println(session.contains(nuwan));
            session.refresh(nuwan);
            System.out.println(session.contains(nuwan));

            session.getTransaction().commit();
        }
    }
}
