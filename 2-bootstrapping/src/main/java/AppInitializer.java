import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AppInitializer {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        System.out.println(session);

        session.close();

        sessionFactory.close();
    }
}
