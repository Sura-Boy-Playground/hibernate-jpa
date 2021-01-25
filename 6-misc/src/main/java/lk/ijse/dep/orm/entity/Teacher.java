package lk.ijse.dep.orm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "teacher")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher implements Serializable {
//    @SequenceGenerator(sequenceName = "teacher_seq", name="seq1", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq1")
@TableGenerator(name ="tbl_seq", table="seq", pkColumnName = "entity", valueColumnName = "value",
        pkColumnValue = "teacher",
        initialValue = 1, allocationSize = 1)
@GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_seq")
    @Id
    private int id;
    @AttributeOverride(name="firstName", column = @Column(name="teacher_first_name"))
    @AttributeOverride(name="lastName", column = @Column(name="teacher_last_name"))
    @Embedded
    private Name name;
    private String contact;

    public Teacher(Name name, String contact) {
        this.name = name;
        this.contact = contact;
    }
}
