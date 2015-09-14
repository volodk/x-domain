package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

// volodymyr_krasnikov1 <vkrasnikov@gmail.com> 5:14:09 PM 

@Entity
@Table(name = "Customers", uniqueConstraints = { @UniqueConstraint(columnNames = { "cnum", "snum" }) })
public class Customer {
    
    @Id
    @Column( name = "cnum" )
    @GeneratedValue(strategy = GenerationType.TABLE)
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + rating;
        result = prime * result + ((salepeople == null) ? 0 : salepeople.hashCode());
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
        Customer other = (Customer) obj;
        if (city == null) {
            if (other.city != null)
                return false;
        } else if (!city.equals(other.city))
            return false;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (rating != other.rating)
            return false;
        if (salepeople == null) {
            if (other.salepeople != null)
                return false;
        } else if (!salepeople.equals(other.salepeople))
            return false;
        return true;
    }
    
}

