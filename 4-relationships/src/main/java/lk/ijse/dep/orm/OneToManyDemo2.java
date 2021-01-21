package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Customer;
import lk.ijse.dep.orm.entity.Order;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;

public class OneToManyDemo2 {

    public static void main(String[] args) {

        try(SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession()){
            session.beginTransaction();

            Order od002 = session.get(Order.class, "OD002");
            Customer salitha = session.get(Customer.class, "C002");
            Customer costa = session.get(Customer.class, "COO1");

            costa.getOrders().add(od002);     //<- we can't do anything about this
            costa.setOrders(costa.getOrders());
//            costa.addOrder(od002);

            session.getTransaction().commit();
        }
    }
}
