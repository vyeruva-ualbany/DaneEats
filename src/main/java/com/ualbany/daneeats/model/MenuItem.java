package com.ualbany.daneeats.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MenuItem extends Persistable {

    private String name;

    private Double price;

    private Integer calories;

    private String description;

    private Restaurant restaurant;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    
    public Double getPrice(){
        return price;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public Integer getCalories(){
        return calories;
    }

    public void setCalories(Integer calories){
        this.calories = calories;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurantId")
    public Restaurant getRestaurant(){
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant){
        this.restaurant = restaurant;
    }
}
