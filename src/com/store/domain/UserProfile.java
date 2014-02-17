package com.store.domain;

import javax.persistence.Basic;
import javax.persistence.Embeddable;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 3:28:13 PM 

@Embeddable
public class UserProfile {
    
    @Basic
    private String name;
    
    @Basic
    private String email;
    
    @Basic
    private byte age;
    
    public UserProfile() {
        // TODO Auto-generated constructor stub
    }
}
