package com.jp.myshop.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jp.myshop.entity.Product;
import com.jp.myshop.entity.StockInfo;
import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

public class SessonFactoryGen {

	private static SessionFactory sf = null;
	

	public static SessionFactory getSessionFactory() {

		if (sf == null) {

			Configuration config = new Configuration();
			config.setProperties(ConnectionProperties.getConnectionProperties());
			config.addAnnotatedClass(Product.class);
			config.addAnnotatedClass(Order.class);
			config.addAnnotatedClass(StockInfo.class);
			sf = config.buildSessionFactory();

		}
	return sf;
	}

}
