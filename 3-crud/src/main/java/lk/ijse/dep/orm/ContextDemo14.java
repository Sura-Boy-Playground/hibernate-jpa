package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Customer;
import lk.ijse.dep.orm.entity.Student;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/* 10 */
public class ContextDemo14 {

    public static void main(String[] args) {

        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {

            session.beginTransaction();

            Customer customer = session.get(Customer.class, 2);
            Student tharanga = new Student(1, "Tharanga", "Matara");
            session.save(tharanga);
            System.out.println("Saving tharanga");
            session.remove(customer);
            System.out.println("Just after remove");
            session.persist(customer);
            System.out.println("Before committing...!");

            session.getTransaction().commit();
        }
    }
}
