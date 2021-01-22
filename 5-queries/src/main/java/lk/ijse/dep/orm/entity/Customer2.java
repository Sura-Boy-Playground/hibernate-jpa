package lk.ijse.dep.orm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@ToString(exclude = "orders")
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="customer2")
public class Customer2 implements Serializable {
    @Id
    private String id;
    private String name;
    private String address;
    @OneToMany(mappedBy = "customer")
    private List<Order2> orders;

    public Customer2(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public void addOrder(Order2 order){
        order.setCustomer(this);
        this.getOrders().add(order);
    }

    public void removeOrder(Order2 order){
        order.setCustomer(null);
        this.getOrders().remove(order);
    }

    public void setOrders(List<Order2> orders) {
        orders.forEach(o-> o.setCustomer(this));
        this.orders = orders;
    }
}
