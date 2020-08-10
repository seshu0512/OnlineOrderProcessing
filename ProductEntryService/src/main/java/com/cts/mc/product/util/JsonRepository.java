package com.cts.mc.product.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.cts.mc.product.vo.Product;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonRepository {
	ObjectMapper mapper = new ObjectMapper();

	// read json ---get UserDetail
	public void readJson(Product product) {
		
		System.out.println(" readJson method start");

		ArrayList<Product> existingProduct = null;
		InputStream input;
		try {
			input = new FileInputStream("D:\\MC\\ProductEntryService\\src\\main\\resources\\Product.json");
			if (input.available() == 0) {
				System.out.println(" Json file is empty----writing first object");
				writeJson(Arrays.asList(product));
			} else {
				System.out.println("Json file is not empty ");
				List<Product> usersList = Arrays.asList(mapper.readValue(input, Product[].class));

				existingProduct = new ArrayList<>(usersList);
				updateJson(existingProduct, product);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
	}

	// write json ---insert User

	public void writeJson(List<Product> product)
			throws JsonGenerationException, JsonMappingException, FileNotFoundException, IOException {
		mapper.writeValue(new FileOutputStream("D:\\MC\\ProductEntryService\\src\\main\\resources\\Product.json"), product);
	}

	// write json ---update iser
	public void updateJson(ArrayList<Product> existingProducts, Product newProduct) {
		System.out.println("UpdateJson method......");
		int initialSize=existingProducts.size();
		System.out.println(" Existing Json objects count "+initialSize);
		
boolean[] flag = {true};
flag[0] = false;

		if (existingProducts.size() == 0) {
			System.out.println("Json file is empty duplicate");
			existingProducts.add(newProduct);
		} else {
			
			System.out.println(" update json method else block ");
			existingProducts.forEach(existingProduct -> {
				if (existingProduct.getProductId().equals(newProduct.getProductId())) {
					System.out.println(" User already exists so updating it ");
					existingProduct.setProductName(newProduct.getProductName());
					existingProduct.setPrice(newProduct.getPrice());
					existingProduct.setPrice(newProduct.getPrice());
					existingProduct.setStock(newProduct.getStock());
					existingProduct.setOffer(newProduct.getOffer());
					flag[0]=true;
				}

			});
			
			System.out.println(" flage is "+ flag[0]);
			if (flag[0]==false) {
				System.out.println("object doesn't exists in json adding it to json ");
				existingProducts.addAll(Arrays.asList(newProduct));
			}
		}

		
		
		try {
			mapper.writeValue(new FileOutputStream("D:\\MC\\ProductEntryService\\src\\main\\resources\\Product.json"),
					existingProducts);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	// remove element from json
	
	public void deleteElementFromJson(String productId) {
		System.out.println(" deleteElementFromJson method ");
		
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
		if (product.getProductId().equals(productId)) {
			existingProducts.remove(product);
			
		}
		
	}
		try {
		writeJson(existingProducts);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//get Product by productId
	
	public Product getProductById(String productId) {
		Product orderedProduct = null;
System.out.println(" deleteElementFromJson method ");
		
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
		if (product.getProductId().equals(productId)) {
			orderedProduct=product;
			
		}
		
	}
		try {
		//writeJson(existingProducts);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderedProduct;
	}

	
	
}
