package lk.ijse.dep.orm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="member")
public class Member implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String name;
    private String address;
    @Column(name="contact_no")
    private String contactNo;
    @Lob
    @Column(name="profile_pic")
    private byte[] profilePic;

    public Member(String name, String address, String contactNo, byte[] profilePic) {
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
        this.profilePic = profilePic;
    }
}
