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
import java.sql.Blob;
import java.sql.SQLException;

public class BlobDemo2 {

    public static void main(String[] args) {
        try(SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession()){
            session.beginTransaction();

            File suchiraProfilePic = new File("/home/ranjith-suranga/Desktop/suchira.jpeg");
            File yohanProfilePic = new File("/home/ranjith-suranga/Desktop/yohan.jpeg");
            FileInputStream fis = new FileInputStream(yohanProfilePic);

            byte[] suchiraBytes = Files.readAllBytes(suchiraProfilePic.toPath());
            Blob yohanBlob = BlobProxy.generateProxy(fis, fis.available()); // Native Hibernate
            SerialBlob suchiraBlob = new SerialBlob(suchiraBytes);  // JPA

            session.save(new Member2("yohan","Rambukkana","077-1234567",yohanBlob));
            session.save(new Member2("Suchira", "Galle", "078-4567891", suchiraBlob));

            fis.close();

            session.getTransaction().commit();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SerialException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
