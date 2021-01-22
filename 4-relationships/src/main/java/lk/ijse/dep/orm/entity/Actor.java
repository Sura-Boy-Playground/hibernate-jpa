package lk.ijse.dep.orm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@ToString(exclude = "movies")
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
    @ManyToMany(mappedBy = "actors")
    private List<Movie> movies;

    public Actor(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void addMovie(Movie movie){
        movie.getActors().add(this);
        movies.add(movie);
    }

    public void removeMovie(Movie movie){
        movie.getActors().remove(this);
        movies.remove(movie);
    }

    public void setMovies(List<Movie> movies) {
        this.movies.forEach(m -> m.getActors().add(this));
        this.movies = movies;
    }
}
