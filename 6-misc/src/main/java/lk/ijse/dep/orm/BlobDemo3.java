package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Member;
import lk.ijse.dep.orm.entity.Member2;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.BlobProxy;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.SQLException;

public class BlobDemo3 {

    public static void main(String[] args) {
        try(SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession()){
            session.beginTransaction();

            Member member = session.get(Member.class, 1);
            Path path = Paths.get("/home/ranjith-suranga/Desktop/temp/yoahan.jpeg");
            Files.write(path, member.getProfilePic());

            Member2 suchira = session.get(Member2.class, 2);
            byte[] bytes = suchira.getProfilePic().getBytes(1, (int) suchira.getProfilePic().length());
            Path path4Suchira = Paths.get("/home/ranjith-suranga/Desktop/temp/suchira.jpeg");
            Files.write(path4Suchira, bytes);

            session.getTransaction().commit();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
