package com.jp.hibernate_mapping.entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class SessonFactoryGenarator {

	private static SessionFactory sf = null;
	
	
	static{
		
		 			Configuration config = new Configuration();
		 			config.setProperties(ConnectionPropertiesUtil.getConnectionProperties());
		 			config.addAnnotatedClass(IpAddress.class);
		 			config.addAnnotatedClass(SystemC.class);
					sf = config.buildSessionFactory();
		
	}

	public static SessionFactory getSessionFactory() {

//		if (sf == null) {
//
//			Configuration config = new Configuration();
//			config.setProperties(ConnectionPropertiesUtil.getConnectionProperties());
//			config.addAnnotatedClass(Register.class);
//			sf = config.buildSessionFactory();
//
//		}
	return sf;
	}

}
