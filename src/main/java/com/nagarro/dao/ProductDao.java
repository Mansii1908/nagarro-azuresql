package com.nagarro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nagarro.model.Product;

public interface ProductDao extends  JpaRepository<Product, Integer> {
	
	@Query(value = "SELECT * FROM Product p WHERE p.product_code= ?1 or p.brand=?1 or p.product_name=?1 ", nativeQuery = true)
	 public List<Product> findSearchedProduct(String filter);
	
	@Query(value = "SELECT description FROM Product p WHERE p.productCode=?1")
	public String getDescription(Integer productCode);
	
	@Query(value = "SELECT price FROM Product p WHERE p.productCode=?1")
	public Double getPrice(Integer productCode);

	@Query(value = "SELECT pin.delivery_time\r\n"
			+ "FROM pincodes pin \r\n"
			+ "inner join product_pincodes pp on pin.pincode = pp.pincode\r\n"
			+ "inner join product p on pp.product_code = p.product_code\r\n"
			+ "where pp.product_code=?1 and pp.pincode=?2",nativeQuery = true)
	public String getServiceability(Integer productCode,String pincode);
	
//	List<Product> findProductsByPincodeId(String pincode);
	
	

}
