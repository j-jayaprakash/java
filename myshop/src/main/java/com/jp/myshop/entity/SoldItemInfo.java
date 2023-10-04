package com.jp.myshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="sold_item_info")
public class SoldItemInfo {


	@Id
	@GenericGenerator(name="alt", strategy = "increment")
	@GeneratedValue(generator = "alt")
	@Column(name="alt_key")
	private long altKey;
	@Column(name="product_id")
	private long productId;
	@Column(name="product_quantity")
	private int quantity;
	@Column(name="total_price")
	private int totalPrice;
	@Column(name="purchase_id")
	private int purchaseId;
	@Column(name="created_date")
	private String createdDate;

	public long getAltKey() {
		return altKey;
	}

	public void setAltKey(long altKey) {
		this.altKey = altKey;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public String getCreatedData() {
		return createdDate;
	}

	public void setCreatedData(String createdData) {
		this.createdDate = createdData;
	}

}
