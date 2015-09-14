package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// volodymyr_krasnikov1 <vkrasnikov@gmail.com> 5:13:51 PM 

@Entity
@Table( name = "Salespeoples" )
public class Salespeople {
    
    @Id
    @Column( name = "snum" )
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    
    @Column(name = "sname", nullable = false)
    private String name;
    
    @Column
    private String city;
    
    @Column( name = "comm" )
    private float commision;
    
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + Float.floatToIntBits(commision);
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + id;
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
        Salespeople other = (Salespeople) obj;
        if (city == null) {
            if (other.city != null)
                return false;
        } else if (!city.equals(other.city))
            return false;
        if (Float.floatToIntBits(commision) != Float.floatToIntBits(other.commision))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (id != other.id)
            return false;
        return true;
    }
    
}
