package lk.ijse.dep.orm;

import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CreateNativeQueryDemo {

    public static void main(String[] args) {

        try(SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession()){
            session.beginTransaction();

            List<Object[]> list = session.
                    createNativeQuery("SELECT id,name,address FROM customer").list();
            for (Object[] objects : list) {
                System.out.println(objects[0]);
                System.out.println(objects[1]);
                System.out.println(objects[2]);
                System.out.println("--------------------------");
            }

            session.getTransaction().commit();
        }
    }
}
