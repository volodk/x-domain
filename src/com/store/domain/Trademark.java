package com.store.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 3:13:52 PM 

@Entity
@Table(name = "t_trademark")
public class Trademark {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(nullable = false)
    private String name;

    public Trademark() {
        // TODO Auto-generated constructor stub
    }
    
}
