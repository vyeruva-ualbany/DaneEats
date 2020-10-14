package com.ualbany.daneeats.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity(name = "Order")
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    private Integer customerId;

    private Integer agentId;
    
    private Integer menuId;

    private Integer status;

    private Double receive;

    private Double pay;

    private String source;

    private String destination;

    private Date created;
	private Date updated;
	
    @PrePersist
    protected void onCreate() {
      setCreated(new Date());
    }
	
	@PreUpdate
	protected void onUpdate() {
	  setUpdated(new Date());
	}

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
    
	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}
}
