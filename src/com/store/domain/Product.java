package com.store.domain;

import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 4:35:39 PM 

@Entity
@Table(name = "t_product")
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Embedded
    private ProductInfo info;
    
    @OneToOne
    private Trademark trademark;
    
    @OneToOne
    private Category category;
    
    @OneToMany
    private Set<Shop> soldByShops;
    
    public Product() {
        // TODO Auto-generated constructor stub
    }
}
