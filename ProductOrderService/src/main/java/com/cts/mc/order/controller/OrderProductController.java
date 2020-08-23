package com.cts.mc.order.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.mc.order.exception.OrderException;
import com.cts.mc.order.model.Order;
import com.cts.mc.order.service.OrderProductService;

@RestController
@RequestMapping("/orderproduct")
public class OrderProductController {
	static Logger log = Logger.getLogger(OrderProductController.class.getName());
	
	@Autowired
	OrderProductService orderProductService;
	@PostMapping("/addToCart")
	public Order addProductToCart(@RequestBody Order order) throws OrderException {
		log.debug("Adding product to cart "+order.getOrderProductId());
		
		return orderProductService.addProductToCart(order);
	}

	@GetMapping("/listCart")
	public List<Order> listCartProducts() throws OrderException {
		log.debug("fetching the products from cart ");
		return orderProductService.listCartProducts();
	}
	@GetMapping("/checkoutProducts/{orderId}")
	
	public String checkoutOrders(@PathVariable int orderId) throws OrderException{
		return orderProductService.checkoutOrders(orderId);
	}

}
