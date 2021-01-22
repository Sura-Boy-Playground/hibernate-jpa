package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Actor;
import lk.ijse.dep.orm.entity.Movie;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ManyToManyDemo3 {

    public static void main(String[] args) {

        try(SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession()){
            session.beginTransaction();

            Movie ageaBalea = session.find(Movie.class, "M002");
            Actor sajeewa = session.find(Actor.class, "A002");
//            ageaBalea.getActors().add(sajeewa);
//            sajeewa.getMovies().add(ageaBalea);
            sajeewa.removeMovie(ageaBalea);

            session.getTransaction().commit();
        }
    }
}
