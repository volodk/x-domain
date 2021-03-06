package domain0;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// volodymyr_krasnikov1 <vkrasnikov@gmail.com> 5:13:51 PM 

@Entity
@Table( name = "Salespeoples" )
public class Salespeople {
    
    @Id
    @Column( name = "snum" )
    private int id;
    
    @Column(name = "sname", nullable = false)
    private String name;
    
    @Column
    private String city;
    
    @Column( name = "comm" )
    private float commision;
    
    @OneToMany(mappedBy = "salepeople")
    private List<Customer> customers;
    
    public Salespeople() {
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

    public float getCommision() {
        return commision;
    }

    public void setCommision(float commision) {
        this.commision = commision;
    }
    
}
