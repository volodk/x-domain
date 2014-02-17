package com.store.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 4:35:31 PM 

@Entity
@Table(name = "t_frige")
public class Frige {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @OneToMany
    @JoinTable(name = "j_frige_product")
    private Set<Product> products;
    
    public Frige() {
        // TODO Auto-generated constructor stub
    }
}
