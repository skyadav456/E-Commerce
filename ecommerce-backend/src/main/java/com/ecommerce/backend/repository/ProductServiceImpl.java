package com.ecommerce.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.backend.model.Product;
import com.ecommerce.backend.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepo;

	@Override
	public Product addProduct(Product product) {
		return productRepo.save(product);
		
	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> list = productRepo.findAll();
		return list;
	}

	@Override
	public Product getProductById(Long Id) {
		Product product = productRepo.findById(Id).orElse(null);
		return product;
	}

	@Override
	public Product updatePtoduct(Long Id, Product product) {
		 Product existing = productRepo.findById(Id).orElse(null);
		    if (existing != null) {
		        existing.setName(product.getName());
		        existing.setDescription(product.getDescription());
		        existing.setPrice(product.getPrice());
		        existing.setStockQuantity(product.getStockQuantity());
		        return productRepo.save(existing);
		    }
		    return null;
		
	}

	@Override
	public void deleteProduct(Long Id) {
		productRepo.deleteById(Id);
	}

}
