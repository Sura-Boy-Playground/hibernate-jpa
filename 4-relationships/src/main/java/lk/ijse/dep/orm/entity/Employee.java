package lk.ijse.dep.orm.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@ToString(exclude = "spouse")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    private String id;
    private String name;
    private String address;
    @OneToOne(mappedBy = "employee")
    private Spouse spouse;

    public Employee(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
