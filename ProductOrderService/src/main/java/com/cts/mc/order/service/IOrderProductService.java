package com.cts.mc.order.service;

import java.util.List;

import com.cts.mc.order.vo.Product;

public interface IOrderProductService {
	public Product addProductToCart(int productId);
	public List<Product> listCartProducts();

}
