package lk.ijse.dep.orm.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@ToString(exclude = "movie2List")
@Entity
@Table(name = "movie2")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Movie2 implements Serializable {
    @Id
    private String id;
    private String name;
    private int duration;
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "movie")
    private List<Actor2Movie2> movie2List;

    public Movie2(String id, String name, int duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }
}
