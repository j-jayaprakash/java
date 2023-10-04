package com.jp.myshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDateTime;

import com.jp.myshop.dto.ProductDto;
import com.jp.myshop.entity.Product;
import com.jp.myshop.entity.StockInfo;
import com.jp.myshop.util.SessonFactoryProduct;
import com.jp.myshop.util.SessonFactoryStock;

public class MyshopDaoImpl implements MyShopDao{

	@Override
	public void addProduct(ProductDto productDto) {
		//product
		Product product = new Product();
		
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		
		LocalDateTime dt=LocalDateTime.now();
		product.setCreatedDate(dt);
		
		Session sessionProduct= SessonFactoryProduct.getSessionFactory().openSession();
		
		Transaction stp = sessionProduct.beginTransaction();
		Product savedProduct =(Product) sessionProduct.merge(product);
		stp.commit();
		
		//stock
		
		StockInfo stockInfo = new StockInfo();
		
		long altKey = savedProduct.getAltKey();
		
		stockInfo.setProductId(altKey);
		stockInfo.setStockNumber(productDto.getQuantity());
		
		Session sessionStock = SessonFactoryStock.getSessionFactory().openSession();
		
		Transaction sts = sessionStock.beginTransaction();
		
		
		sessionStock.save(stockInfo);
		
		sts.commit();
		
		
	
		
		
		
		
		
	}

	@Override
	public void sellItem(List<Product> products) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getSoldProductForCurrentDate(long productId) {
		// TODO Auto-generated method stub
		
	}

}
