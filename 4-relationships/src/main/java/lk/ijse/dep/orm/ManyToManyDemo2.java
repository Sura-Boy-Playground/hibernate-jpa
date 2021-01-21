package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Actor;
import lk.ijse.dep.orm.entity.Movie;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class ManyToManyDemo2 {

    public static void main(String[] args) {

        try(SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession()){
            session.beginTransaction();

            Movie ageaBalea = session.get(Movie.class, "M002");
            ageaBalea.getActors().clear();

            Actor uvin = session.get(Actor.class, "A004");
            session.remove(uvin);

            session.getTransaction().commit();
        }
    }
}
