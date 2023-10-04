package com.jp.myshop.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Table(name="product_info")
@Entity
public class Product {

	@Id
	@GenericGenerator(name="alt", strategy = "increment")
	@GeneratedValue(generator = "alt")
	@Column(name="alt_key")
	private long altKey;
	@Column(name="product_name")
	private String name;
	@Column(name="produc_price")
	private int price;
	@Column(name="created_date")
	private LocalDateTime createdDate;
	@Column(name="modified_date")
	private String modifiedDate;
	
	

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public long getAltKey() {
		return altKey;
	}

	public void setAltKey(long altKey) {
		this.altKey = altKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
