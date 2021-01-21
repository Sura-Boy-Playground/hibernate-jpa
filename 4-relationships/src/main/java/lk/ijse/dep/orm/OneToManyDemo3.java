package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Customer;
import lk.ijse.dep.orm.entity.Order;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToManyDemo3 {

    public static void main(String[] args) {

        try(SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession()){
            session.beginTransaction();

            Customer costa = session.get(Customer.class, "COO1");
            Order od002 = session.get(Order.class, "OD002");
            session.remove(od002);

            session.getTransaction().commit();
        }
    }
}
