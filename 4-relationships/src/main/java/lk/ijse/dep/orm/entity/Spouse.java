package lk.ijse.dep.orm.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="spouse")
public class Spouse {

    @Id
    private String id;
    private String name;
    private String contact;
    @OneToOne
    @JoinColumn(name="employee_id", referencedColumnName = "id", nullable = false)
    private Employee employee;

}
