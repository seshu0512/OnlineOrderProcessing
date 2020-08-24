package com.cts.mc.product.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.mc.product.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
