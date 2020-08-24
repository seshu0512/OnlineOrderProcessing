package com.cts.mc.order.service;

import java.util.List;

import com.cts.mc.order.exception.OrderException;
import com.cts.mc.order.model.Order;

public interface IOrderProductService {
	public Order addProductToCart(Order order)throws OrderException;
	public List<Order> listCartProducts()throws OrderException;
	public String checkoutOrders(int productId)throws OrderException ;

}
