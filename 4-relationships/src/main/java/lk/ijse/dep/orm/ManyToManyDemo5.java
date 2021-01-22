package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Actor2;
import lk.ijse.dep.orm.entity.Actor2Movie2;
import lk.ijse.dep.orm.entity.Actor2Movie2PK;
import lk.ijse.dep.orm.entity.Movie2;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;

public class ManyToManyDemo5 {

    public static void main(String[] args) {

        try(SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession()){
            session.beginTransaction();

            Actor2 sajeewa = session.get(Actor2.class, "A002");
            Actor2 uvin = session.get(Actor2.class, "A004");
            Movie2 ageaBalea = session.get(Movie2.class, "M002");
            Movie2 asaiManPiyaabanna = session.get(Movie2.class, "M003");
//
//            Actor2Movie2 actor2Movie2 = new Actor2Movie2(sajeewa.getId(), ageaBalea.getId(), new Date());
//            session.save(actor2Movie2);

//            Actor2Movie2 actor2Movie2 = session.get(Actor2Movie2.class, new Actor2Movie2PK(sajeewa.getId(), ageaBalea.getId()));
//            session.remove(actor2Movie2);

            Actor2Movie2 actor2Movie2 = session.get(Actor2Movie2.class, new Actor2Movie2PK(uvin.getId(), ageaBalea.getId()));
//            System.out.println(actor2Movie2.getMovie());
//            System.out.println(actor2Movie2.getActor());
//            actor2Movie2.setMovie(asaiManPiyaabanna);

            System.out.println(uvin.getActor2Movie2s().get(0).getMovie());


            session.getTransaction().commit();
        }
    }
}
