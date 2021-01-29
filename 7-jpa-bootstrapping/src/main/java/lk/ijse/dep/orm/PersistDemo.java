package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PersistDemo {

    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("dep-6");
            em = emf.createEntityManager();
            em.getTransaction().begin();

            em.persist(new Customer("Kasun", "Galle"));

            em.getTransaction().commit();
        }catch (Throwable t){
            if (em != null){
                em.getTransaction().rollback();
            }
            t.printStackTrace();
        }finally{
            em.close();
            emf.close();
        }

    }
}
