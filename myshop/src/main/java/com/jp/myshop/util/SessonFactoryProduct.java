package com.jp.myshop.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jp.myshop.entity.Product;

public class SessonFactoryProduct {

	private static SessionFactory sf = null;
	

	public static SessionFactory getSessionFactory() {

		if (sf == null) {

			Configuration config = new Configuration();
			config.setProperties(ConnectionProperties.getConnectionProperties());
			config.addAnnotatedClass(Product.class);
			sf = config.buildSessionFactory();

		}
	return sf;
	}

}
