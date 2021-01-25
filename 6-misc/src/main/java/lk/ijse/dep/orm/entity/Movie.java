package lk.ijse.dep.orm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "movie")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Movie implements Serializable {
    @Id
    private String id;
    private String name;
    private int duration;
    @ManyToMany
    @JoinTable(name="actor_movie", joinColumns = @JoinColumn(name="movie_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name="actor_id", referencedColumnName = "id"))
    private List<Actor> actors;

    public Movie(String id, String name, int duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }
}
