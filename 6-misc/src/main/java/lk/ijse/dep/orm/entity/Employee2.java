package lk.ijse.dep.orm.entity;

import lk.ijse.dep.orm.util.Designation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "employee2")
public class Employee2 implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String name;
    private String address;
    @Enumerated(EnumType.STRING)
    private Designation designation;

    public Employee2(String name, String address, Designation designation) {
        this.name = name;
        this.address = address;
        this.designation = designation;
    }
}
