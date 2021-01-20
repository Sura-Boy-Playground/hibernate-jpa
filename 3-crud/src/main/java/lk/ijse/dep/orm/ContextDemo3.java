package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Customer;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ContextDemo3 {

    public static void main(String[] args) {

        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {

            session.beginTransaction();

            Customer salitha = session.get(Customer.class, 1);
            System.out.println(salitha);
            salitha.setAddress("Galle");
            System.out.println(salitha);
            Customer salitha2 = session.get(Customer.class, 1);
            System.out.println(salitha2);

            session.getTransaction().commit();
        }
    }
}
