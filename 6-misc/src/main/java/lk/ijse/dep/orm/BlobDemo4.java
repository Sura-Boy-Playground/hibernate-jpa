package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Member;
import lk.ijse.dep.orm.entity.Member2;
import lk.ijse.dep.orm.entity.Member3;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;

public class BlobDemo4 {

    public static void main(String[] args) {
        try(SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession()){
            session.beginTransaction();
            //session.save(new Member3("suchira","matara","077-1234567","/home/ranjith-suranga/Desktop/suchira.jpeg"));

            Member3 suchira = session.get(Member3.class, 1);
            Path path = Paths.get(suchira.getProfilePic());
            byte[] bytes = Files.readAllBytes(path);

            Path path1 = Paths.get("/home/ranjith-suranga/Desktop/temp/suchira.jpeg");
            Files.write(path1, bytes);

            session.getTransaction().commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
