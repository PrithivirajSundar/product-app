package com.chainsys.product.dao;

import java.util.Set;

import com.chainsys.product.model.Product;

public interface ProductDAO {
	Set<Product> findAll();

	Product findById(int id);
	Product findByName(String Name);

	void save(Product product);

	void update(Product product);
	void updateExpiryDate(Product product);

	void delete(int id);
}
