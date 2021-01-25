package lk.ijse.dep.orm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class CustomEntity implements Serializable {
    private String actorId;
    private String actorName;
    private Date joinedDate;
    private String movieName;
}
