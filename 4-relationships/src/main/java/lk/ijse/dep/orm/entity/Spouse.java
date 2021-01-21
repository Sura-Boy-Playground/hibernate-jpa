package lk.ijse.dep.orm.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="spouse")
public class Spouse implements Serializable {

    @Id
    private String id;
    private String name;
    private String contact;
    @OneToOne
    @JoinColumn(name="employee_id", referencedColumnName = "id", nullable = false, unique = true)
    private Employee employee;

}
