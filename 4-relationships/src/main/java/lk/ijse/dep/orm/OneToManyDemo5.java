package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Customer2;
import lk.ijse.dep.orm.entity.Order2;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;

public class OneToManyDemo5 {

    public static void main(String[] args) {

        try(SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession()){
            session.beginTransaction();

            Customer2 costa = session.get(Customer2.class, "C001");
            Order2 od002 = session.get(Order2.class, "OD002");
//            od002.setCustomer(shalitha);

//            shalitha.getOrders().add(od002);      // << this is iteslef not going to work
//            shalitha.setOrders(shalitha.getOrders());

//            shalitha.addOrder(od002);

            costa.removeOrder(costa.getOrders().get(1));

            session.getTransaction().commit();
        }
    }
}
