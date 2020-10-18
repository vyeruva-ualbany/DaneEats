package com.ualbany.daneeats.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderItem extends Persistable {

    private Order order;

    private MenuItem Item;

    private Integer quantity;

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "orderId")
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "menuId")
	public MenuItem getMenuItem() {
		return Item;
	}

	public void setMenuItem(MenuItem Item) {
		this.Item = Item;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
