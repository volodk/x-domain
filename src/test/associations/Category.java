package test.associations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 4:35:49 PM 

@Entity
@Table(name = "t_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(nullable = false)
    private String name;
    
    @ManyToOne
    @JoinColumn(columnDefinition = "parent_id", referencedColumnName = "id")
    private Category parent;
    
    public Category() {
        // TODO Auto-generated constructor stub
    }
}
