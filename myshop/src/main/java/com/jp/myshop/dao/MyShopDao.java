package com.jp.myshop.dao;

import java.util.List;

import com.jp.myshop.dto.ProductDto;
import com.jp.myshop.entity.Product;

public interface MyShopDao {
	
	
	void addProduct(ProductDto productDto);
	
	void sellItem(List<Product> products);
	
	void getSoldProductForCurrentDate(long productId);

}
