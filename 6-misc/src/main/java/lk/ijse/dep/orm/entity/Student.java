package lk.ijse.dep.orm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
//    @SequenceGenerator(sequenceName = "student_seq", name="seq1", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq1")
    @TableGenerator(name ="tbl_seq", table="seq", pkColumnName = "entity", valueColumnName = "value", pkColumnValue = "student",
    initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_seq")
    @Id
    private int id;
    @AttributeOverride(name="firstName", column = @Column(name="student_first_name"))
    @AttributeOverride(name="lastName", column = @Column(name="student_last_name"))
    @Embedded
    private Name name;
    private String grade;

    public Student(Name name, String grade) {
        this.name = name;
        this.grade = grade;
    }
}
