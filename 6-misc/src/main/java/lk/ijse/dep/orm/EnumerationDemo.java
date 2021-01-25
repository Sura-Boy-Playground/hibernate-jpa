package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Employee2;
import lk.ijse.dep.orm.entity.Student;
import lk.ijse.dep.orm.entity.Teacher;
import lk.ijse.dep.orm.util.Designation;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public class EnumerationDemo {

    public static void main(String[] args) {
        try(SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession()){
            session.beginTransaction();

            Employee2 supun = new Employee2("Supun", "Galle", Designation.CEO);
            Employee2 kasun = new Employee2("Kasun", "Matara", Designation.CTO);
            Employee2 nuwan = new Employee2("Nuwan", "Nuwara Eliya", Designation.LABOUR);

            session.persist(supun);
            session.persist(kasun);
            session.persist(nuwan);

            System.out.println("Saved!");

            session.getTransaction().commit();
        }
    }
}
