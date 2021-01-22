package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.*;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;

public class ManyToManyDemo4 {

    public static void main(String[] args) {

        try(SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession()){
            session.beginTransaction();

            Actor2 costa = new Actor2("A001", "Costa", 25);
            Actor2 sajeewa = new Actor2("A002", "sajeewa", 25);
            Actor2 yohan = new Actor2("A003", "yohan", 25);
            Actor2 uvin = new Actor2("A004", "uvin", 22);

            Movie2 bahubali = new Movie2("M001", "Bahubali", 500);
            Movie2 ageaBalea = new Movie2("M002", "Agea Balea", 500);
            Movie2 asaiManPiyaabanna = new Movie2("M003", "Asai Man Piyaabanna", 500);

            Actor2Movie2 actor2Movie20 = new Actor2Movie2(costa.getId(), bahubali.getId(), new Date());
            Actor2Movie2 actor2Movie21 = new Actor2Movie2(costa.getId(), asaiManPiyaabanna.getId(), new Date());
            Actor2Movie2 actor2Movie22 = new Actor2Movie2(sajeewa.getId(), asaiManPiyaabanna.getId(), new Date());
            Actor2Movie2 actor2Movie23 = new Actor2Movie2(yohan.getId(), bahubali.getId(), new Date());
            Actor2Movie2 actor2Movie24 = new Actor2Movie2(uvin.getId(), ageaBalea.getId(), new Date());

            session.save(costa);
            session.save(sajeewa);
            session.save(yohan);
            session.save(uvin);

            session.save(bahubali);
            session.save(ageaBalea);
            session.save(asaiManPiyaabanna);

            session.save(actor2Movie20);
            session.save(actor2Movie21);
            session.save(actor2Movie22);
            session.save(actor2Movie23);
            session.save(actor2Movie24);

            session.getTransaction().commit();
        }
    }
}
