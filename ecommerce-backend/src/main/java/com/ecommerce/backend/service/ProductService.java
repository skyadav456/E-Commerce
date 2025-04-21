package com.ecommerce.backend.service;

import java.util.List;

import com.ecommerce.backend.model.Product;

public interface ProductService {
	Product addProduct(Product product);
	List<Product> getAllProduct();
	Product getProductById(Long Id);
	
	Product updatePtoduct(Long Id, Product product);
	void deleteProduct(Long Id);

}
