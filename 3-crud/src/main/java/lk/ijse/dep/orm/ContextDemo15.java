package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Customer;
import lk.ijse.dep.orm.entity.Student;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/* 10 */
public class ContextDemo15 {

    public static void main(String[] args) {

        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {

            session.beginTransaction();

            Student anupama = new Student(2, "Anupama", "Galle");
            Customer sajeewa = session.get(Customer.class, 2);
            session.save(anupama);
            System.out.println("Saved Anpupama");
            sajeewa.setAddress("Sajeewa+");
            System.out.println("Changed name");
            session.remove(sajeewa);
            System.out.println("Removed");
            session.persist(sajeewa);
            System.out.println("Saved Sajeewa");
            session.getTransaction().commit();
        }
    }
}
