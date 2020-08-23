package com.cts.mc.product.service;

import com.cts.mc.product.exception.ProductException;
import com.cts.mc.product.model.Product;

public interface IProductService {
	public Product addProduct(Product product)throws ProductException;
	public Product updateProduct(Product product)throws ProductException;
	public String deleteProduct(Long productId)throws ProductException;
	public Product getProductById(Long productId)throws ProductException;
}
