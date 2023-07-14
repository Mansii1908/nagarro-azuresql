package com.nagarro.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.model.Pincode;
import com.nagarro.model.Product;
import com.nagarro.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	
	//get all products
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> products=this.productService.getAllProducts();
		try {
			return ResponseEntity.status(HttpStatus.OK).body(products);
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}	
	}
	
	//get list of searched products 
	@GetMapping("/products/{filter}")
	public ResponseEntity<List<Product>> GetProduct(@PathVariable String filter) {
		List<Product> products=this.productService.getSearchedProduct(filter);
		if(products.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(products);
	}
	
	//get description of product 
	@GetMapping("/products/{productCode}/description")
	public ResponseEntity<String> getDescription(@PathVariable Integer productCode) {
		String description=this.productService.getDescription(productCode);
		if(description!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(description);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	//get price of product
	@GetMapping("/products/{productCode}/price")
	public ResponseEntity<Double> getPrice(@PathVariable Integer productCode) {
		Double price=this.productService.getPrice(productCode);
		if(price!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(price);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PostMapping("/products")
	public void addProduct() {
		Product product1=new Product(1,"Laptop","Dell","black 64 gb laptop",50000,"https://www.bhphotovideo.com/images/images2500x2500/dell_inspiron_17_i17rv_5454blk_17_3_1004767.jpg");
		Product product2=new Product(2,"Sneakers","Puma","White puma logo sneakers",3000,"https://cdna.lystit.com/photos/dsw/0578405c/puma-White-Rebound-Layup-Sl-High-top-Sneaker.jpeg");
		Product product3=new Product(3,"Laptop","HP","Blue 64 gb laptop",70000,"https://rukminim1.flixcart.com/image/416/416/laptop-accessories-combo/u/r/r/hp-blue-2in1-laptop-skins-with-laptop-screen-guard-hq-15-6-inch-original-imae4cebxp89r32u.jpeg?q=70");
		Pincode amritsar=new Pincode("143001","Amritsar","3 days");
		Pincode jalander=new Pincode("143002","Jalander","2 days");
		Pincode ludhiana=new Pincode("141401","Ludhiana","2 days");
		Pincode gurgaon=new Pincode("122003","Gurgaon","1 day");
		Pincode delhi=new Pincode("110001","Delhi","1 day");
		
		
		product1.getPincodes().add(amritsar);
		product1.getPincodes().add(jalander);
		product1.getPincodes().add(ludhiana);
		product1.getPincodes().add(gurgaon);
		product1.getPincodes().add(delhi);
		
		amritsar.getProducts().add(product1);
		jalander.getProducts().add(product1);
		ludhiana.getProducts().add(product1);
		gurgaon.getProducts().add(product1);
		delhi.getProducts().add(product1);
		
		this.productService.addProduct(product1);
		
		product2.getPincodes().add(amritsar);
		product2.getPincodes().add(jalander);
		product2.getPincodes().add(ludhiana);
		product2.getPincodes().add(gurgaon);
		product2.getPincodes().add(delhi);
		
		amritsar.getProducts().add(product2);
		jalander.getProducts().add(product2);
		ludhiana.getProducts().add(product2);
		gurgaon.getProducts().add(product2);
		delhi.getProducts().add(product2);	
		
		this.productService.addProduct(product2);
		
		product3.getPincodes().add(amritsar);
		product3.getPincodes().add(jalander);
		product3.getPincodes().add(ludhiana);
		product3.getPincodes().add(gurgaon);
		product3.getPincodes().add(delhi);
		
		amritsar.getProducts().add(product3);
		jalander.getProducts().add(product3);
		ludhiana.getProducts().add(product3);
		gurgaon.getProducts().add(product3);
		delhi.getProducts().add(product3);	
		
		this.productService.addProduct(product3);
	}
	
	//get serviceability of particular product in given pincode
	@GetMapping("/products/{productCode}/{pincode}")
	public ResponseEntity<String> getServiceability(@PathVariable Integer productCode,@PathVariable String pincode) {
		String result= this.productService.getServiceability(productCode,pincode);
		if(result==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Deliverable");
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(result);
		}
	}
	
	
	
	
	
	
}
