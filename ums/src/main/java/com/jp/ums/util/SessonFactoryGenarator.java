package com.jp.ums.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jp.ums.entity.Register;
import com.jp.ums.util.ConnectionPropertiesUtil;

public class SessonFactoryGenarator {

	private static SessionFactory sf = null;
	
	
	static{
		
		 			Configuration config = new Configuration();
		 			config.setProperties(ConnectionPropertiesUtil.getConnectionProperties());
		 			config.addAnnotatedClass(Register.class);
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
