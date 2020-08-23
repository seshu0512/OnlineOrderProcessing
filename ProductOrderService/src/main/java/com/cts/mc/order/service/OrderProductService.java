package com.cts.mc.order.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.mc.order.dao.CartJsonRepository;
import com.cts.mc.order.dao.OrderRepository;
import com.cts.mc.order.exception.OrderException;
import com.cts.mc.order.model.EmailMessage;
import com.cts.mc.order.model.Order;
import com.cts.mc.order.model.Product;

@Service
public class OrderProductService implements IOrderProductService {
	static Logger log = Logger.getLogger(OrderProductService.class.getName());
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	CartJsonRepository cartJsonRepository;
	@Autowired
	OrderRepository orderRepository;

	@Override

	public Order addProductToCart(Order order) throws OrderException {

		Product product=restTemplate.getForObject("http://ProductEntryService/product/get/{productId}", Product.class, order.getOrderProductId());

		Order orderInCart = null ;
		if(product.getStock()>1) {
			order.setPrice(product.getPrice());
			orderInCart=orderRepository.save(order);
			log.debug("prodcut added to cart");
		}
		else {
			log.debug("prodcut not available");
		}
		return orderInCart;
	}

	@Override
	public List<Order> listCartProducts() throws OrderException {
		// TODO Auto-generated method stub
//		List<Product> cartProducts = cartJsonRepository.getProductFromCart();
		List<Order> cartProducts =(List<Order>) orderRepository.findAll();
		return cartProducts;
	}

	@Override
	public String checkoutOrders(int orderId) throws OrderException {
		List<Order> orders = listCartProducts();
		for (Order order : orders) {		
		EmailMessage emailMessage = new EmailMessage();
		emailMessage.setTo_address("seshu.modepalli@gmail.com");
		emailMessage.setOrderId(order.getOrderId());
		emailMessage.setBody("Your order for the Order id: "+orderId+ " is confirmed");
		restTemplate.getForObject("https://emailconfirmationservice/email/send",EmailMessage.class,emailMessage);
		}
		return "Your Order Confirmed";
	}
	

}
