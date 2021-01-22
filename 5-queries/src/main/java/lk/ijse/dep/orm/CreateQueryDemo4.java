package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Customer;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CreateQueryDemo4 {

    public static void main(String[] args) {

        try(SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession()){
            session.beginTransaction();

            List<Customer> list = session.createQuery("SELECT c FROM Customer c WHERE c.name LIKE ?1 AND c.address LIKE :address", Customer.class)
                    .setParameter(1, "C%")
                    .setParameter("address", "G%")
                    .list();

            list.forEach(System.out::println);


            session.getTransaction().commit();
        }
    }
}
