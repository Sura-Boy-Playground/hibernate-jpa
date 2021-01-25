package lk.ijse.dep.orm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "`order2`")
public class Order2 implements Serializable {
    @Id
    private String id;
    private Date date;
    @ManyToOne
    @JoinTable(name = "customer2_order2",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id", unique = true),
            inverseJoinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"))
    private Customer2 customer;

    public Order2(String id, Date date) {
        this.id = id;
        this.date = date;
    }
}
