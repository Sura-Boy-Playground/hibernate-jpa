package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Customer;
import lk.ijse.dep.orm.entity.Order;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class NamedNativeQueryDemo {

    public static void main(String[] args) {

        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            session.beginTransaction();

            List<Order> list = session.getNamedNativeQuery("all-orders").addEntity(Order.class).list();
            list.forEach(System.out::println);

            System.out.println("-------------------------------");

            List<Object[]> list1 = session.createNamedQuery("query3").list();
            for (Object[] row : list1) {
                System.out.println("order id: =" + row[0]);
                System.out.println("order date: =" + row[1]);
                System.out.println("customer id: =" + row[2]);
                System.out.println("customer name: =" + row[3]);
                System.out.println("----------------------");
            }

            session.getTransaction().commit();
        }
    }
}
