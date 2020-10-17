package com.ualbany.daneeats.model;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Restaurant extends Persistable {

    private String name;

    private String phone;

    private String address1;

    private String address2;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getAddress1(){
        return address1;
    }

    public void setAddress1(String address1){
        this.address1 = address1;
    }

    public String getAddress2(){
        return address2;
    }

    public void setAddress2(String address2){
        this.address2 = address2;
    }
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="restaurantId")
    private Set<MenuItem> menuItems;

}
