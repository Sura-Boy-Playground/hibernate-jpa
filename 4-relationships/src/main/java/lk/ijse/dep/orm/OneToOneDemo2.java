package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Employee;
import lk.ijse.dep.orm.entity.Spouse;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToOneDemo2 {

    public static void main(String[] args) {

        try(SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession()){
            session.beginTransaction();

//            Spouse kocchiAmma = session.get(Spouse.class, "S001");
//            Employee tharanga = kocchiAmma.getEmployee();

//            Employee tharanga = session.get(Employee.class, "E001");
//            System.out.println(tharanga.getSpouse());

            Spouse kocchiAmma = session.get(Spouse.class, "S001");
            Spouse thunudMathi = session.get(Spouse.class, "S002");
            Employee tharanga = session.get(Employee.class, "E001");
            Employee sathiya = session.get(Employee.class, "E002");

//            kocchiAmma.setEmployee(sathiya);
            tharanga.setSpouse(kocchiAmma);

            session.getTransaction().commit();
        }
    }
}
