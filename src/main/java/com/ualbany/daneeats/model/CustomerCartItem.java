package com.ualbany.daneeats.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "CustomerCart")
@NamedQuery(name = "CustomerCartItem.findByCustomerId", query = "SELECT i FROM CustomerCartItem i WHERE LOWER(i.customerId) = ?1")
public class CustomerCartItem {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
	private Integer customerId;
	private Integer menuId;
	private Double price;
	private Integer count;
	private String source;
	private String destination;
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer userId) {
		this.customerId = userId;
	}

	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}

}
