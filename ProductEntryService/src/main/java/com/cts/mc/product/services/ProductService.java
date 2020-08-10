package com.cts.mc.product.services;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.mc.product.util.JsonRepository;
import com.cts.mc.product.vo.Product;

@RestController
@RequestMapping("/product")
public class ProductService  implements IProductService{

	JsonRepository jsonRepository = new JsonRepository();
	
	@Override
	@RequestMapping("/add/{product}")
	public Product addProduct(@RequestBody Product product) {
		// TODO Auto-generated method stub
		jsonRepository.readJson(product);
		return product;
	}
	@Override
	@RequestMapping("/update/{product}")
	public Product updateProduct(@RequestBody Product product) {
		// TODO Auto-generated method stub
		jsonRepository.readJson(product);
		return product;
	}
	@Override
	@RequestMapping("/delete")
	public Product deleteProduct(@RequestParam String productId) {
		System.out.println(" delete method");
		// TODO Auto-generated method stub
		jsonRepository.deleteElementFromJson(productId);
		return null;
	}

	@Override
	@RequestMapping(value = "/get")
	public Product getProductById(@RequestParam String productId) {
		// TODO Auto-generated method stub
		Product product = jsonRepository.getProductById(productId);
		return  product;
	}

}
