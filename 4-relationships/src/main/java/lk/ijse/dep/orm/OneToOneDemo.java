package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Employee;
import lk.ijse.dep.orm.entity.Spouse;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToOneDemo {

    public static void main(String[] args) {

        try(SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession()){
            session.beginTransaction();

            Employee emp = new Employee("E001", "Tharanga", "Galle");
            Spouse spouse = new Spouse("S001", "Kocchi Amma", "077-1234567", emp);
            session.save(emp);
            session.save(spouse);

            session.getTransaction().commit();
        }
    }
}
