package com.cts.mc.order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_order")
public class Order {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	 
	@Column(name="orderId")
	private Long orderId;
	@Column(name="userId")
	private Long userId;
	@Column(name="orderProductId")
	private Long orderProductId;
	@Column(name="noOfUnits")
	private int noOfUnits;
	@Column(name="price")
	private double price;
	
	public Order() {
	}

	public Order(Long orderId,Long userId,  Long orderProductId, int noOfUnits, double price) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.orderProductId = orderProductId;
		this.noOfUnits = noOfUnits;
		this.price = price;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getOrderProductId() {
		return orderProductId;
	}

	public void setOrderProductId(Long orderProductId) {
		this.orderProductId = orderProductId;
	}

	public int getNoOfUnits() {
		return noOfUnits;
	}

	public void setNoOfUnits(int noOfUnits) {
		this.noOfUnits = noOfUnits;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

		
}
