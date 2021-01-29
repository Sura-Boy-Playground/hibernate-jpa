package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Properties;

public class PersistDemo {

    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        EntityManager em = null;

        Properties prop = new Properties();

        try {
            prop.load(PersistDemo.class.getResourceAsStream("/application.properties"));
            emf = Persistence.createEntityManagerFactory("dep-6", prop);
            em = emf.createEntityManager();
            em.getTransaction().begin();

            em.persist(new Student("Sathiya"));
            em.persist(new Student("Sajeewa"));
            em.persist(new Student("Costa"));
            em.persist(new Student("Poorni"));
            em.persist(new Student("Desh Sha"));

            em.getTransaction().commit();
        } catch (Throwable t) {
            if (em != null) {
                em.getTransaction().rollback();
            }
            t.printStackTrace();
        } finally {
            emf.close();
            em.close();
        }
    }
}
