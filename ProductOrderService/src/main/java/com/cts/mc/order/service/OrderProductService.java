package com.cts.mc.order.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.mc.order.repository.CartJsonRepository;
import com.cts.mc.order.vo.Product;

@RestController
@RequestMapping("/OrderProduct")
public class OrderProductService implements IOrderProductService{
	CartJsonRepository cartJsonRepository = new CartJsonRepository();
	@Override
	@RequestMapping("/addToCart/{productId}")
	public Product addProductToCart(@PathVariable int productId) {
		
		
		Product product=cartJsonRepository.getProductById(productId);
		cartJsonRepository.writeJson(product);
		// TODO Auto-generated method stub
		return product;
	}

	@Override
	@RequestMapping("/listCart")
	public List<Product> listCartProducts() {
		// TODO Auto-generated method stub
		List<Product> cartProducts = cartJsonRepository.getProductFromCart();
		return cartProducts;
	}

}
