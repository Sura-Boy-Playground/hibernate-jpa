package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Customer;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;

/* 6 */
public class ContextDemo6 {

    public static void main(String[] args) {

        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {

            session.beginTransaction();

            Customer des = new Customer(2, "Desh Sha", "Kiribathgoada");
            session.save(des);
            des.setAddress("Kiri");
            System.out.println("Changed address");

            session.getTransaction().commit();
        }
    }
}
