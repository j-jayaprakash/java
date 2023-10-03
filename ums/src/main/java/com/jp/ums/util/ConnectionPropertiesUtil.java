package com.jp.ums.util;

import java.util.Properties;

import org.hibernate.cfg.Environment;

public class ConnectionPropertiesUtil {
	
	
	public static Properties getConnectionProperties() {
		
		
		Properties properties = new Properties();
		
		properties.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/operational_db");
		
		properties.setProperty(Environment.USER, "root");
		
		properties.setProperty(Environment.PASS, "root");
		
		properties.setProperty(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		
		properties.setProperty(Environment.HBM2DDL_AUTO,"update");
		
		properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
		
		properties.setProperty(Environment.SHOW_SQL, "true");
		
		return properties;
	}
	

}
