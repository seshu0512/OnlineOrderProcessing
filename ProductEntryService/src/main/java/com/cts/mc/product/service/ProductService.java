package com.cts.mc.product.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.mc.product.dao.ProductRepository;
import com.cts.mc.product.exception.ProductException;
import com.cts.mc.product.model.Product;

@Service
public class ProductService implements IProductService{
@Autowired
ProductRepository productRepository;
	@Override
	public Product addProduct(Product product) throws ProductException {
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) throws ProductException {
		return productRepository.save(product);
		
	}

	@Override
	public String deleteProduct(Long productId) throws ProductException {
		 productRepository.deleteById(productId);
		 return "Product Deleted Successfully";
	}

	@Override
	public Product getProductById(Long productId) throws ProductException {
		 Optional<Product> optionalProduct =  productRepository.findById(productId);
		 Product product =null;
		 if(optionalProduct.isPresent()) {
			 product= optionalProduct.get();
		 }
		 return product;
	}

}
