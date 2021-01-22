package lk.ijse.dep.orm.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name="actor2_movie2")
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Actor2Movie2 implements Serializable {

    @EmbeddedId
    private Actor2Movie2PK actor2Movie2PK;
    @Column(name="joined_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date joinedDate;
    @ManyToOne
    @Setter(AccessLevel.NONE)
    @JoinColumn(name="actor_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Actor2 actor;
    @ManyToOne
    @Setter(AccessLevel.NONE)
    @JoinColumn(name="movie_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Movie2 movie;

    public Actor2Movie2(String actorId, String movieId, Date joinedDate) {
        this.actor2Movie2PK = new Actor2Movie2PK(actorId, movieId);
        this.joinedDate = joinedDate;
    }

    public Actor2Movie2(Actor2Movie2PK actor2Movie2PK, Date joinedDate) {
        this.actor2Movie2PK = actor2Movie2PK;
        this.joinedDate = joinedDate;
    }
}
