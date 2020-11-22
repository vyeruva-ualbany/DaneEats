package com.ualbany.daneeats.model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity(name = "Order")
@Table(name = "Orders")
public class Order extends Persistable {

	
	private int orderId;
	
    public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderId() {
		return orderId;
	}
    

	private User customer;

    private User agent;
    
    private OrderStatus status;

    private double amount;

    private String source;

    private String destination;
    
    private String phoneNumber;
	
    private List<OrderItem> items = new ArrayList<OrderItem>();
    public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}


	int num;
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId", nullable = false, updatable = false)
	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "agentId")
	public User getAgent() {
		return agent;
	}

	public void setAgent(User agent) {
		this.agent = agent;
	}

	
    @Enumerated(EnumType.STRING)
	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
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
	
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="orderId")
	public List<OrderItem> getItems() {
		return items;
	}
	
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	
	public void addOrderItem(OrderItem item) {
		item.setOrder(this);
		this.items.add(item);
	}
	
	public void removeOrderItem(OrderItem item) {
		this.items.remove(item);
		item.setOrder(null);
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
