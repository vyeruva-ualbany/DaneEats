package com.ualbany.daneeats.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity(name = "Order")
@Table(name = "Orders")
public class Order extends Persistable {

    private User customer;

    private User agent;
    
    private OrderStatus status;

    private double amount;

    private String source;

    private String destination;
	
    private Set<OrderItem> items;
    
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

	@Column(name = "orderStatus")
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
	public Set<OrderItem> getItems() {
		return items;
	}
	
	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}
}
