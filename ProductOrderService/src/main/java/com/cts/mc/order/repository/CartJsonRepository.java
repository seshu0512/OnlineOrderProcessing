package com.cts.mc.order.repository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import com.cts.mc.order.vo.Product;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class CartJsonRepository {

	//get Product by productId
	ObjectMapper mapper = new ObjectMapper();
	
		public Product getProductById(int productId) {
			Product orderedProduct = null;
	System.out.println(" get product by productId");
			
			CopyOnWriteArrayList<Product> existingProducts = new CopyOnWriteArrayList<>();
			InputStream input;
			try {
				input = new FileInputStream("D:\\MC\\ProductEntryService\\src\\main\\resources\\Product.json");
				if (input.available() == 0) {
					System.out.println(" Json file is empty----writing first object");
				} else {
					System.out.println("Json file is not empty ");
					List<Product> usersList = Arrays.asList(mapper.readValue(input, Product[].class));

					existingProducts = new CopyOnWriteArrayList<>(usersList);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			;
			
			
			//deletion logic
			Iterator<Product> existingProductsIterator= existingProducts.iterator();
			
		while (existingProductsIterator.hasNext()) {
			Product product = (Product) existingProductsIterator.next();
			if (product.getProductId()==(productId)) {
				orderedProduct=product;
				
			}
			
		}
//			try {
//			writeJson(orderedProduct);
//			}
//			catch (Exception e) {
//				e.printStackTrace();
//			}
			
			return orderedProduct;
		}
		public void writeJson(Product product) {
			try {
			mapper.writeValue(new FileOutputStream("D:\\MC\\ProductOrderService\\src\\main\\resources\\CartData.json"), product);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		//list the products from cart
		
		public List<Product> getProductFromCart() {
			
			List<Product> cartList=null;
			System.out.println(" deleteElementFromJson method ");
			
			
			InputStream input;
			try {
				input = new FileInputStream("D:\\MC\\ProductEntryService\\src\\main\\resources\\Product.json");
				if (input.available() == 0) {
					System.out.println(" Json file is empty----writing first object");
				} else {
					System.out.println("Json file is not empty ");
					cartList = Arrays.asList(mapper.readValue(input, Product[].class));

				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			;
			return cartList;
		}
	
}
