package com.chainsys.product.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.chainsys.product.dao.ProductDAO;
import com.chainsys.product.dao.ProductDAOImpl;
import com.chainsys.product.exception.ProductNotFoundException;
import com.chainsys.product.model.Product;

public class ProductServiceImpl implements ProductService {
	private static ProductDAO dao;

	public ProductServiceImpl() {
		dao = new ProductDAOImpl();
	}

	@Override
	public Set<Product> findAll() {
		return dao.findAll();
	}
	
	@Override
	public List<String> findAllName() {
		return dao.findAllName();
	}

	@Override
	public List<Integer> findAllId() {
		return dao.findAllId();
	}

	
	@Override
	public Product findById(int id) throws ProductNotFoundException {
		Product Product = dao.findById(id);
		if (Product == null) {
			throw new ProductNotFoundException("Product Id Not Found");
		} else {
			return Product;
		}
	}
	
	@Override
	public Product findByName(String Name) throws ProductNotFoundException {
		Product Product = dao.findByName(Name);
		if (Product == null) {
			throw new ProductNotFoundException("Product Name Not Found");
		} else {
			return Product;
		}
	}
	
	@Override
	public Product findByDate(LocalDate expiryDate) throws ProductNotFoundException {
		Product Product = dao.findByDate(expiryDate);
		if (Product == null) {
			throw new ProductNotFoundException("Product Name Not Found");
		} else {
			return Product;
		}
	}


	@Override
	public void save(Product Product) {
		dao.save(Product);

	}

	@Override
	public void update(Product Product) throws ProductNotFoundException {
		Product result = dao.findById(Product.getId());
		if (result == null) {
			throw new ProductNotFoundException("Product Id Not Found");
		} else {
			dao.update(Product);
		}

	}

	@Override
	public void updateExpiryDate(Product Product) throws ProductNotFoundException {
		Product result = dao.findById(Product.getId());
		if (result == null) {
			throw new ProductNotFoundException("Product Id Not Found");
		} else {
			dao.updateExpiryDate(Product);
		}

	}

	
	@Override
	public void delete(int id) throws ProductNotFoundException {
		Product Product = dao.findById(id);
		if (Product == null) {
			throw new ProductNotFoundException("Product doesn't exist!!");
		} else {
			dao.delete(id);
		}
	}
	
	@Override
	public void deleteproduct(LocalDate expiryDate) throws ProductNotFoundException {
		Product Product = dao.findByDate(expiryDate);
		if (Product == null) {
			throw new ProductNotFoundException("Product doesn't exist!!");
		} else {
			dao.deleteproduct(expiryDate);
		}
	}
	
	@Override
	public void deleteproduct(String Name) throws ProductNotFoundException {
		Product Product = dao.findByName(Name);
		if (Product == null) {
			throw new ProductNotFoundException("Product doesn't exist!!");
		} else {
			dao.deleteproduct(Name);
		}
	}


}
