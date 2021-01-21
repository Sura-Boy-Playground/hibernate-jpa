package lk.ijse.dep.orm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="customer")
public class Customer implements Serializable {
    @Id
    private String id;
    private String name;
    private String address;
}
