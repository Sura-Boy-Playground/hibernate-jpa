import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AppInitializer {

    public static void main(String[] args) {

        try(SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session = sf.openSession()){

            session.beginTransaction();

//            Customer salitha = new Customer(1, "Salitha", "Matara");
//            session.save(salitha);

            session.getTransaction().commit();

        }

    }
}
