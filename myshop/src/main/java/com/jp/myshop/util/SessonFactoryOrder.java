package com.jp.myshop.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jp.myshop.entity.Product;
import com.jp.myshop.entity.SoldItemInfo;
import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

public class SessonFactoryOrder {

	private static SessionFactory sf = null;
	

	public static SessionFactory getSessionFactory() {

		if (sf == null) {

			Configuration config = new Configuration();
			config.setProperties(ConnectionProperties.getConnectionProperties());
			config.addAnnotatedClass(SoldItemInfo.class);
			sf = config.buildSessionFactory();

		}
	return sf;
	}

}
