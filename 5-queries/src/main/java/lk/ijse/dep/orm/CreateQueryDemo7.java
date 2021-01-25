package lk.ijse.dep.orm;

import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateQueryDemo7 {

    public static void main(String[] args) {

        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            session.beginTransaction();

            int affectedRows = session.
                    createQuery("UPDATE Customer c SET c.address=?2 WHERE c.id=?1")
                    .setParameter(1, "C002")
                    .setParameter(2, "Matara").executeUpdate();
            System.out.println(affectedRows > 0);

            session.getTransaction().commit();
        }
    }
}
