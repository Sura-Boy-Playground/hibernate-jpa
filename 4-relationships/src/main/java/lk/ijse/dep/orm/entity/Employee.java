package lk.ijse.dep.orm.entity;

import lombok.*;
import org.hibernate.annotations.Cascade;

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
//    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToOne(mappedBy = "employee", cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REMOVE}, fetch = FetchType.EAGER)
//    @Setter(AccessLevel.NONE)
    private Spouse spouse;

    public Employee(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public void setSpouse(Spouse spouse) {
        spouse.setEmployee(this);
        this.spouse = spouse;
    }
}
