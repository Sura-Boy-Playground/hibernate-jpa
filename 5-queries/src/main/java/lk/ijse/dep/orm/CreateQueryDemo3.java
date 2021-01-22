package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Customer;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CreateQueryDemo3 {

    public static void main(String[] args) {

        try(SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession()){
            session.beginTransaction();

            List<Object[]> customers2 = session.
                    createQuery("SELECT c.id, c.name FROM Customer c").list();
            for (Object[] objects : customers2) {
                System.out.println(objects[0]);
                System.out.println(objects[1]);
                System.out.println("--------------------");
            }

            session.getTransaction().commit();
        }
    }
}
