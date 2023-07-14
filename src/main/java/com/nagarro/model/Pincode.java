package com.nagarro.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pincodes")
public class Pincode {

	@Id
	@Column(name = "pincode")
	private String pincode;

	@Column(name = "city_name")
	private String cityName;

	@Column(name = "delivery_time")
	private String deliveryTime;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "pincodes")
	@JsonIgnore
	private Set<Product> products = new HashSet<>();

	
	public Pincode() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Pincode(String pincode, String cityName, String deliveryTime) {
		super();
		this.pincode = pincode;
		this.cityName = cityName;
		this.deliveryTime = deliveryTime;
	}


	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
}
