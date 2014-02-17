package com.store.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 1:35:55 PM 

@Entity
@Table(name = "t_user_basket")
public class Basket {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @OneToMany
    @JoinTable(name = "j_basket_product")
    private Set<Product> products;
    
    public Basket() {
        // TODO Auto-generated constructor stub
    }
}
