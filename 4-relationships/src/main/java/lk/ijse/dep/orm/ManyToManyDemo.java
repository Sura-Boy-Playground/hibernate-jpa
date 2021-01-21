package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Actor;
import lk.ijse.dep.orm.entity.Customer;
import lk.ijse.dep.orm.entity.Movie;
import lk.ijse.dep.orm.entity.Order;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ManyToManyDemo {

    public static void main(String[] args) {

        try(SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession()){
            session.beginTransaction();

            Actor costa = new Actor("A001", "Costa", 25);
            Actor sajeewa = new Actor("A002", "sajeewa", 25);
            Actor yohan = new Actor("A003", "yohan", 25);
            Actor uvin = new Actor("A004", "uvin", 22);

            Movie bahubali = new Movie("M001", "Bahubali", 500);
            Movie ageaBalea = new Movie("M002", "Agea Balea", 500);
            Movie asaiManPiyaabanna = new Movie("M003", "Asai Man Piyaabanna", 500);

            List<Actor> bahubaliActors = new ArrayList<>();
            bahubaliActors.add(costa);
            bahubaliActors.add(yohan);
            bahubali.setActors(bahubaliActors);

            List<Actor> ageaBaleaActors = new ArrayList<>();
            ageaBaleaActors.add(uvin);
            ageaBalea.setActors(ageaBaleaActors);

            List<Actor> asaiManPiyaabannaActors = new ArrayList<>();
            asaiManPiyaabannaActors.add(costa);
            asaiManPiyaabannaActors.add(sajeewa);
            asaiManPiyaabanna.setActors(asaiManPiyaabannaActors);

            session.save(costa);
            session.save(yohan);
            session.save(sajeewa);
            session.save(uvin);
            session.save(bahubali);
            session.save(ageaBalea);
            session.save(asaiManPiyaabanna);

            session.getTransaction().commit();
        }
    }
}
