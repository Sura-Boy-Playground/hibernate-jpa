package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindDemo {

    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("dep-6");
            em = emf.createEntityManager();
            em.getTransaction().begin();

            Customer customer = em.find(Customer.class, 1);
            System.out.println(customer);

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
