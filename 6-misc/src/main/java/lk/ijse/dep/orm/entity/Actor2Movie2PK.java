package lk.ijse.dep.orm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data @NoArgsConstructor @AllArgsConstructor
@Embeddable
public class Actor2Movie2PK implements Serializable {
    @Column(name = "actor_id")
    private String actorId;
    @Column(name="movie_id")
    private String movieId;
}
