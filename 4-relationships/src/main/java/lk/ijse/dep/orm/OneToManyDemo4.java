package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Customer;
import lk.ijse.dep.orm.entity.Customer2;
import lk.ijse.dep.orm.entity.Order;
import lk.ijse.dep.orm.entity.Order2;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;

public class OneToManyDemo4 {

    public static void main(String[] args) {

        try(SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession()){
            session.beginTransaction();

            Customer2 costa = new Customer2("C001", "Costa", "Galkissea");
            Customer2 shalitha = new Customer2("C002", "Shalitha", "Matara");
            Order2 od001 = new Order2("OD001", new Date(System.currentTimeMillis()), costa);
            Order2 od002 = new Order2("OD002", new Date(System.currentTimeMillis()), costa);
            Order2 od003 = new Order2("OD003", new Date(System.currentTimeMillis()), shalitha);
            Order2 od004 = new Order2("OD004", new Date(System.currentTimeMillis()));

            session.save(costa);
            session.save(shalitha);
            session.save(od001);
            session.save(od002);
            session.save(od003);
            session.save(od004);

            session.getTransaction().commit();
        }
    }
}
