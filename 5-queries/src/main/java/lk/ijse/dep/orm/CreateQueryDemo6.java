package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.CustomEntity;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

import java.util.List;

public class CreateQueryDemo6 {

    public static void main(String[] args) {

        try(SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession()){
            session.beginTransaction();

            int affectedRows = session.createQuery("DELETE FROM Customer c WHERE c.id=?1")
                    .setParameter(1, "C004").executeUpdate();
            System.out.println(affectedRows > 0);

            session.getTransaction().commit();
        }
    }
}
