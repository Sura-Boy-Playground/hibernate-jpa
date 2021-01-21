package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Customer;
import lk.ijse.dep.orm.entity.Employee;
import lk.ijse.dep.orm.entity.Order;
import lk.ijse.dep.orm.entity.Spouse;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;

public class OneToManyDemo {

    public static void main(String[] args) {

        try(SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession()){
            session.beginTransaction();

            Customer costa = new Customer("COO1", "Costa", "Galkissa");
            Order od001 = new Order("OD001", new Date(System.currentTimeMillis()), costa);
            Order od002 = new Order("OD002", new Date(System.currentTimeMillis()), costa);
            session.save(costa);
            session.save(od001);
            session.save(od002);

            session.getTransaction().commit();
        }
    }
}
