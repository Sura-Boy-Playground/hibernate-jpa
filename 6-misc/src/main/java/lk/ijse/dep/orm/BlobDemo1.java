package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Member;
import lk.ijse.dep.orm.entity.Name;
import lk.ijse.dep.orm.entity.Student;
import lk.ijse.dep.orm.entity.Teacher;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.*;
import java.nio.file.Files;

public class BlobDemo1 {

    public static void main(String[] args) {
        try(SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession()){
            session.beginTransaction();

            File suchiraProfilePic = new File("/home/ranjith-suranga/Desktop/suchira.jpeg");
            File yohanProfilePic = new File("/home/ranjith-suranga/Desktop/yohan.jpeg");
            FileInputStream fis = new FileInputStream(yohanProfilePic);
            byte[] profilePic = new byte[fis.available()];
            fis.read(profilePic);

            byte[] suchiraBytes = Files.readAllBytes(suchiraProfilePic.toPath());

//            session.save(new Member("yohan","Rambukkana","077-1234567",profilePic));
            session.save(new Member("Suchira", "Galle", "078-4567891", suchiraBytes));

            fis.close();

            session.getTransaction().commit();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
