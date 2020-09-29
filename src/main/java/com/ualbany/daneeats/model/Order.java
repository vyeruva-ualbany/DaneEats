package com.ualbany.daneeats.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "Order")
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    private Integer customerId;

    private Integer agentId;

    private Integer status;

    private Double receive;

    private Double pay;

    private String source;

    private String destination;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderedDate;

    public Integer getId(){
        return Id;
    }

    public Integer getCustomerId(){
        return customerId;
    }

    public void setCustomerId(Integer customerId){
        this.customerId = customerId;
    }
    
    public Integer getAgentId(){
        return agentId;
    }

    public void setAgentId(Integer agentId){
        this.agentId = agentId;
    }

    public Integer getStatus(){
        return status;
    }

    public void setStatus(Integer status){
        this.status = status;
    }

    public Double getReceive(){
        return receive;
    }

    public void setReceive(Double receive){
        this.receive = receive;
    }

    public Double getPay(){
        return pay;
    }

    public void setPay(Double pay){
        this.pay = pay;
    }

    public String getSource(){
        return source;
    }

    public void setSource(String source){
        this.source = source;
    }

    public String getDestination(){
        return destination;
    }

    public void setDestination(String destination){
        this.source = destination;
    }
    
    public Date getOrderedDate(){
        return orderedDate;
    }
    
    public void setOrderedDate(Date orderedDate){
        this.orderedDate = orderedDate;
    }
}
