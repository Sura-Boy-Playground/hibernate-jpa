package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Customer;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CreateNativeQueryDemo2 {

    public static void main(String[] args) {

        try(SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession()){
            session.beginTransaction();

            List<Customer> list = session.
                    createNativeQuery("SELECT id,name,address FROM customer")
                    .addEntity(Customer.class).list();
            list.forEach(System.out::println);

            session.getTransaction().commit();
        }
    }
}
