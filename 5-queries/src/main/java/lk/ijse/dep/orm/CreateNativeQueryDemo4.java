package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Customer;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CreateNativeQueryDemo4 {

    public static void main(String[] args) {

        try(SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession()){
            session.beginTransaction();

            List<Customer> list = session.
                    createNativeQuery("SELECT id,name,address FROM customer WHERE name LIKE ?1", Customer.class)
                    .setParameter(1,"C%")
                    .getResultList();
            list.forEach(System.out::println);

            List<Customer> list2 = session.
                    createNativeQuery("SELECT id,name,address FROM customer WHERE name LIKE :customer_name",
                            Customer.class)
                    .setParameter("customer_name","C%")
                    .getResultList();
            list2.forEach(System.out::println);

            System.out.println("---------------------");

            List<Customer> list3 = session.
                    createNativeQuery("SELECT id,name,address FROM customer " +
                            "WHERE name LIKE ?1 AND address LIKE ?2", Customer.class)
                    .setParameter(1,"C%")
                    .setParameter(2,"G%")
                    .getResultList();
            list3.forEach(System.out::println);

            session.getTransaction().commit();
        }
    }
}
