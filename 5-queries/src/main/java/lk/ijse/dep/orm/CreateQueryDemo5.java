package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.CustomEntity;
import lk.ijse.dep.orm.entity.Customer;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

import java.util.List;

public class CreateQueryDemo5 {

    public static void main(String[] args) {

        try(SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession()){
            session.beginTransaction();

            /* SELECT o.id, o.date, c.name FROM customer c INNER JOIN `order` o ON o.customerId = c.id WHERE c.id= ? */
            List<Object[]> ordersList = session.
                    createQuery("SELECT o.id, o.date, c.name FROM Customer c INNER JOIN c.orders o WHERE c.id = ?1")
                    .setParameter(1, "C003").list();
            for (Object[] order : ordersList) {
                System.out.println("ORDER ID: " + order[0]);
                System.out.println("ORDER DATE: " + order[1]);
                System.out.println("CUSTOMER NAME: " + order[2]);
                System.out.println("-------------------------");
            }

            List<CustomEntity> actors = session.
                    createQuery
                    ("SELECT new lk.ijse.dep.orm.entity.CustomEntity(a.id, a.name, am.joinedDate, am.movie.name) " +
                            "FROM Actor2Movie2  am" +
                    " INNER JOIN am.actor a  WHERE am.actor2Movie2PK.movieId = ?1")
                    .setParameter(1, "M001").list();

            actors.forEach(System.out::println);

            System.out.println("-------------- NATIVE QUERIES (SQL) ---------------");

            List<CustomEntity> actorInfo = session.
                    createNativeQuery("SELECT a.id as actorId, a.name as actorName, am.joined_date as joinedDate, m.name as movieName " +
                            "FROM actor2_movie2 am INNER JOIN actor2 a ON a.id=am.actor_id " +
                            "INNER JOIN movie2 m ON m.id=am.movie_id WHERE am.movie_id=?1")
                    .setParameter(1, "M001").setResultTransformer(Transformers.aliasToBean(CustomEntity.class))
                    .list();

//            for (Object[] info : actorInfo) {
//                System.out.println("ID: " + info[0]);
//                System.out.println("Name: " + info[1]);
//                System.out.println("JOINED DATE: " + info[2]);
//                System.out.println("MOVIE: " + info[3]);
//                System.out.println("------------------");
//            }

            actorInfo.forEach(System.out::println);

            session.getTransaction().commit();
        }
    }
}
