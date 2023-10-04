package com.jp.myshop.dao;

import java.util.List;

import com.jp.myshop.dto.OrderDto;
import com.jp.myshop.dto.ProductDto;

public interface MyShopDao {
	
	
	void addProduct(ProductDto productDto);
	
	void sellItem(List<OrderDto> products);
	
	void getSoldProductForCurrentDate(long productId);
	
	Object getById(long altKey);

}
