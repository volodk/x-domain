package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Customers", uniqueConstraints = { @UniqueConstraint(columnNames = { "cnum", "snum" }) })
public class Customer {
    
    @Id
    @Column( name = "cnum" )
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "customer_id_gen", sequenceName = "customer_seq")
    private int id;
    
    @Column(name = "cname", nullable = false)
    private String name;
    
    @Column
    private String city;
    
    @Column
    private int rating;
    
    @ManyToOne
    @JoinColumn(name = "snum")
    private Salespeople salepeople;
    
    public Customer() {
        // TODO Auto-generated constructor stub
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Salespeople getSalepeople() {
        return salepeople;
    }

    public void setSalepeople(Salespeople salepeople) {
        this.salepeople = salepeople;
    }
    
}

