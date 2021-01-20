package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Customer;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ContextDemo5 {

    public static void main(String[] args) {

        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {

            session.beginTransaction();

            Customer customer = session.get(Customer.class, 2);
            customer.setAddress("Colombo");
            session.remove(customer);
            System.out.println("Haii...kollo api yanawa...!");

            session.getTransaction().commit();
        }
    }
}
