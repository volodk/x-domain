package domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// volodymyr_krasnikov1 <vkrasnikov@gmail.com> 5:14:23 PM 

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @Column(name = "onum")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    @Column(name = "amt")
    private float amount;

    @Column(name = "odate", nullable = false)
    private Date orderDate;

    @ManyToOne
    @JoinColumns({ @JoinColumn(columnDefinition = "cnum"), @JoinColumn(columnDefinition = "snum") })
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(amount);
        result = prime * result + ((customer == null) ? 0 : customer.hashCode());
        result = prime * result + id;
        result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
            return false;
        if (customer == null) {
            if (other.customer != null)
                return false;
        } else if (!customer.equals(other.customer))
            return false;
        if (id != other.id)
            return false;
        if (orderDate == null) {
            if (other.orderDate != null)
                return false;
        } else if (!orderDate.equals(other.orderDate))
            return false;
        return true;
    }
    
}

