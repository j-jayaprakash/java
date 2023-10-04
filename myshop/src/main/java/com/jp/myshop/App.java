package com.jp.myshop;

import java.util.Scanner;

import com.jp.myshop.dao.MyshopDaoImpl;
import com.jp.myshop.dto.OrderDto;
import com.jp.myshop.dto.ProductDto;

public class App {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		System.out.println("Wellcome to MyShop ");
		
		for(int i=0;i<10;i++) {

    	ProductDto product = new ProductDto();
    	
    	System.out.println("enter product name");
    	product.setName(scn.next());
    	System.out.println("enter price of the Product");
    	product.setPrice(scn.nextInt());
    	
    	System.out.println("enter quantity available");
    	product.setQuantity(scn.nextInt());
    		
    	
    	MyshopDaoImpl ms=new MyshopDaoImpl();
    	
    	ms.addProduct(product);

    	
		}
    	
		OrderDto order1 = new OrderDto();

		order1.setProductId(1);
		order1.setQuantity(2);

		OrderDto order2 = new OrderDto();

		order2.setProductId(2);
		order2.setQuantity(1);

	}
}
