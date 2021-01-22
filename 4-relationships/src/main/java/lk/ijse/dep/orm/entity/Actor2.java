package lk.ijse.dep.orm.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@ToString(exclude = "actor2Movie2s")
@Table(name = "actor2")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Actor2 implements Serializable {
    @Id
    private String id;
    private String name;
    private int age;
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "actor")
    private List<Actor2Movie2> actor2Movie2s;

    public Actor2(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
