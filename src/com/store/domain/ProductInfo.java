package com.store.domain;

import javax.persistence.Basic;
import javax.persistence.Embeddable;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 3:37:51 PM 

@Embeddable
public class ProductInfo {

    @Basic
    private String name;
    
    public ProductInfo() {
        // TODO Auto-generated constructor stub
    }
}
