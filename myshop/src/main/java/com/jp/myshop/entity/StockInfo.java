package com.jp.myshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="stock_info")
public class StockInfo {

	@Id
	@GenericGenerator(name="alt", strategy = "increment")
	@GeneratedValue(generator = "alt")
	@Column(name="alt_key")
	private long altKey;
	
	@Column(name="product_id")
	private long productId;
	@Column(name="stock_number")
	private int stockNumber;

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

	public int getStockNumber() {
		return stockNumber;
	}

	public void setStockNumber(int stockNumber) {
		this.stockNumber = stockNumber;
	}

	@Override
	public String toString() {
		return "StockInfo [altKey=" + altKey + ", productId=" + productId + ", stockNumber=" + stockNumber + "]";
	}

	
}
