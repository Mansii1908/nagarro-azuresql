package com.nagarro.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_code")
	private int productCode;

	@Column(name = "product_name")
	private String productName;

	private String brand;
	private String description;
	private double price;
	private String image;
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "product_pincodes", joinColumns = { @JoinColumn(name = "product_code") }, inverseJoinColumns = {
			@JoinColumn(name = "pincode") })
	private Set<Pincode> pincodes = new HashSet<>();

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int productCode, String productName, String brand, String description, double price, String image) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.brand = brand;
		this.description = description;
		this.price = price;
		this.image = image;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Set<Pincode> getPincodes() {
		return pincodes;
	}

	public void setPincodes(Set<Pincode> pincodes) {
		this.pincodes = pincodes;
	}

//	public void addTag(Pincode pincode) {
//		this.pincodes.add(pincode);
//		pincode.getProducts().add(this);
////	    tag.getTutorials().add(this);
//
//	}

//	  public void removeTag(String pincode) {
//	    Tag tag = this.tags.stream().filter(t -> t.getId() == tagId).findFirst().orElse(null);
//	    if (tag != null) this.tags.remove(tag);
//	    tag.getTutorials().remove(this);
//	  }
//	

}
