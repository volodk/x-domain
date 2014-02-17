package com.store.domain;

import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 4:35:22 PM 

@Entity
@Table(name = "t_user")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Embedded
    private UserProfile userProfile;
    
    @OneToOne
    @JoinColumn(columnDefinition = "frige_id", referencedColumnName = "id")
    private Frige frige;
    
    @OneToOne
    @JoinColumn(columnDefinition = "basket_id", referencedColumnName = "id")
    private Basket basket;
    
    @OneToMany
    @JoinTable(name = "j_user_loyalty")
    private Set<Trademark> loyalToTrademarks;
    
    public User() {
        // TODO Auto-generated constructor stub
    }
}
