package com.nagarro.service;

import java.util.List;
import java.util.Optional;

import com.nagarro.model.Product;


public interface ProductService {
	public List<Product> getAllProducts();
	public List<Product> getSearchedProduct(String filter);
	public String getDescription(Integer productCode);
	public Double getPrice(Integer productCode);
	
	public Product addProduct(Product product);
	public String getServiceability(Integer productCode, String pincode);

}
