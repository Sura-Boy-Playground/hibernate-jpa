package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Customer;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public class SaveOrUpdateDemo {

    public static void main(String[] args) {

        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {

            session.beginTransaction();

/*            Customer customer = session.get(Customer.class, 2);
            session.evict(customer);
            customer.setAddress("India");*/
            Customer customer = new Customer(10, "Anpuama","Galle");
            session.saveOrUpdate(customer);
            System.out.println(session.contains(customer));

            session.getTransaction().commit();
        }
    }
}
