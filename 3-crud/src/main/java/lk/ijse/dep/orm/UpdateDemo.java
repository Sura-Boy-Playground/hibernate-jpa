package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Customer;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public class UpdateDemo {

    public static void main(String[] args) {

        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {

            session.beginTransaction();

            Customer nuwan = session.get(Customer.class, 2);
            System.out.println("In Persistence Context? " + session.contains(nuwan));
            session.evict(nuwan);
            System.out.println("In Persistence Context? " + session.contains(nuwan));
            Customer anotherNuwan = session.get(Customer.class, 2);
            session.update(nuwan);
            System.out.println("In Persistence Context? " + session.contains(nuwan));

            session.getTransaction().commit();
        }
    }
}
