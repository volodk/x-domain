package domain0;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

// volodymyr_krasnikov1 <vkrasnikov@gmail.com> 5:14:23 PM 

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @Column(name = "onum")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "order_id_gen", sequenceName = "order_seq")
    private int id;

    @Column(name = "amt")
    private float amount;

    @Column(name = "odate", nullable = false)
    private Date orderDate;

    @ManyToOne
    private Customer customer;

    public Order() {
        // TODO Auto-generated constructor stub
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
}

