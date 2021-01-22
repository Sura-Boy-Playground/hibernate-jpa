package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Customer;
import lk.ijse.dep.orm.entity.Order;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;

public class OneToManyFetchDemo {

    public static void main(String[] args) {

        try(SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession()){
            session.beginTransaction();

            Customer costa = session.get(Customer.class, "COO1");
            System.out.println(Hibernate.isInitialized(costa.getOrders()));
            System.out.println("----------------------");
            System.out.println(costa.getOrders().get(0));
            System.out.println(Hibernate.isInitialized(costa.getOrders()));

            session.getTransaction().commit();
        }
    }
}
