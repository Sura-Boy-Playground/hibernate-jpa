package lk.ijse.dep.orm.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

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

}
