package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Employee;
import lk.ijse.dep.orm.entity.Spouse;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToOneCascadeDemo {

    public static void main(String[] args) {

        try(SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession()){
            session.beginTransaction();

//            Employee emp = new Employee("E003", "Dilanka", "Galle");
//            Spouse spouse = new Spouse("S003", "Sumana", "077-1234567", emp);
//            emp.setSpouse(spouse);
//            session.save(emp);

            Employee sathiya = session.get(Employee.class, "E002");
            System.out.println(session.contains(sathiya));
            System.out.println(session.contains(sathiya.getSpouse()));
            session.detach(sathiya);
            System.out.println(session.contains(sathiya));
            System.out.println(session.contains(sathiya.getSpouse()));

            session.getTransaction().commit();
        }
    }
}
