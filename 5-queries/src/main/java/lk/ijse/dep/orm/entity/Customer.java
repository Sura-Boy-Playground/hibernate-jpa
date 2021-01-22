package lk.ijse.dep.orm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@ToString(exclude = "orders")
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="customer")
public class Customer implements Serializable {
    @Id
    private String id;
    private String name;
    private String address;
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    public Customer(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public void addOrder(Order order){
        order.setCustomer(this);
        getOrders().add(order);
    }

//    public void removeOrder(Order order){
//        order.setCustomer(null);
//        getOrders().remove(order);
//    }

    public void setOrders(List<Order> orders) {
        orders.forEach(o-> o.setCustomer(this));
        this.orders = orders;
    }
}
