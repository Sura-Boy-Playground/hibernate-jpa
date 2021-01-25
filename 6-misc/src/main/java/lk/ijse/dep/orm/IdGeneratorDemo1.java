package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Name;
import lk.ijse.dep.orm.entity.Student;
import lk.ijse.dep.orm.entity.Teacher;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public class IdGeneratorDemo1 {

    public static void main(String[] args) {
        try(SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession()){
            session.beginTransaction();

            Student vibath = new Student( new Name("Vibath","Kasun"), "Walana");
            session.persist(vibath);
            System.out.println("Saved..!");

            Teacher shalitha = new Teacher( new Name("Shalitha", "Anuradha"), "077-1234567");
            Serializable id = session.save(shalitha);
            System.out.println(id);
            System.out.println("Saved! " + id);

            session.getTransaction().commit();
        }
    }
}
