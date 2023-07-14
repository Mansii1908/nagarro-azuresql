package com.nagarro.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.ProductDao;
import com.nagarro.model.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
//	List<Product> list;
	
	@Autowired
	private ProductDao productDao;
	

//	public ProductServiceImpl() {
//		list=new ArrayList<Product>();
//	}



	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
	
		return this.productDao.findAll();
	}

	@Override
	public List<Product> getSearchedProduct(String filter) {
//		Product p=null;
//		for(Product product:list) {
//			if(product.getProductCode()==pId) {
//				p=product;
//				break;
//			}
//		}
		return this.productDao.findSearchedProduct(filter);
	}

	@Override
	public String getDescription(Integer productCode) {
		// TODO Auto-generated method stub
		return this.productDao.getDescription(productCode);
	}

	@Override
	public Double getPrice(Integer productCode) {
		// TODO Auto-generated method stub
		return this.productDao.getPrice(productCode);
	}

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return this.productDao.save(product);
	}

	@Override
	public String getServiceability(Integer productCode, String pincode) {
		return this.productDao.getServiceability(productCode,pincode);
	}

}
