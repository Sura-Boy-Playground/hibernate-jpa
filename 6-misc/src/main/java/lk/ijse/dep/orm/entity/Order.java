package lk.ijse.dep.orm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@NamedNativeQuery(name="all-orders", query = "SELECT * FROM `order`")
@NamedNativeQuery(name="query3", query =
        "SELECT o.id as `order_id`, date, c.id, name FROM `order` o INNER JOIN customer c on o.customer_id = c.id")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "`order`")
public class Order implements Serializable {
    @Id
    private String id;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
}
