package lk.ijse.dep.orm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "actor")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Actor implements Serializable {
    @Id
    private String id;
    private String name;
    private int age;
}
