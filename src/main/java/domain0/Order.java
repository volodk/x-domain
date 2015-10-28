package domain0;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// volodymyr_krasnikov1 <vkrasnikov@gmail.com> 5:14:23 PM 

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @Column(name = "onum")
    private int id;

    @Column(name = "amt")
    private float amount;

    @Column(name = "odate", nullable = false)
    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "cnum")
    private Customer customer;
    
    @ManyToOne
    @JoinColumn(name = "snum")
    private Salespeople sales;

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
    
    public Salespeople getSales() {
        return sales;
    }
    
    public void setSales(Salespeople sales) {
        this.sales = sales;
    }
    
}

