package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Customer;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ContextDemo2 {

    public static void main(String[] args) {

        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {

            session.beginTransaction();

            Customer salitha = session.get(Customer.class, 1);
            Customer costa = session.get(Customer.class, 2);

            Customer salitha2 = session.get(Customer.class, 1);
            Customer costa2 = session.get(Customer.class, 2);

            System.out.println(salitha == salitha2);
            System.out.println(costa == costa2);

            session.getTransaction().commit();
        }
    }
}
