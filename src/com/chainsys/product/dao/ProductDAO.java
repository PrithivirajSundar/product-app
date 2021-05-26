package com.chainsys.product.dao;

import java.time.LocalDate;
import java.util.Set;

import com.chainsys.product.model.Product;

public interface ProductDAO {
	Set<Product> findAll();

	Product findById(int id);
	Product findByName(String Name);
	Product findByDate(LocalDate expiryDate);

	void save(Product product);

	void update(Product product);
	void updateExpiryDate(Product product);

	void delete(int id);
	void deleteproduct(LocalDate expiryDate);
}