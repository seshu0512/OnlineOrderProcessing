package com.cts.mc.product.services;

import com.cts.mc.product.vo.Product;

public interface IProductService {

	public Product addProduct(Product product);
	public Product updateProduct(Product product);
	public Product deleteProduct(String productId);
	public Product getProductById(String productId);
}
