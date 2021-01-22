package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Customer;
import lk.ijse.dep.orm.entity.Employee;
import lk.ijse.dep.orm.entity.Order;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class OneToOneCascadeDemo2 {

    public static void main(String[] args) {

        try(SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession()){
            session.beginTransaction();

//            Customer nuwan = new Customer("C003", "Nuwan", "Galle");
//            List<Order> orders = new ArrayList<>();
//            orders.add(new Order("OD005", new Date(System.currentTimeMillis()), nuwan));
//            orders.add(new Order("OD006", new Date(System.currentTimeMillis()), nuwan));
//            orders.add(new Order("OD007", new Date(System.currentTimeMillis()), nuwan));
//            nuwan.setOrders(orders);
//            session.persist(nuwan);

            Customer nuwan = session.get(Customer.class, "C003");
            nuwan.getOrders().add(new Order("OD008", new Date(System.currentTimeMillis()), nuwan));

            session.getTransaction().commit();
        }
    }
}
