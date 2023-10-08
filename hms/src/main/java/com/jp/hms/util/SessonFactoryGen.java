package com.jp.hms.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jp.hms.entity.Appointment;
import com.jp.hms.entity.Doctor;
import com.jp.hms.entity.User;

public class SessonFactoryGen {

	private static SessionFactory sf = null;
	

	public static SessionFactory getSessionFactory() {

		if (sf == null) {

			Configuration config = new Configuration();
			
			config.setProperties(ConnectionProperties.getConnectionProperties());
			config.addAnnotatedClass(User.class);
			config.addAnnotatedClass(Doctor.class);
			config.addAnnotatedClass(Appointment.class);
			sf = config.buildSessionFactory();

		}
	return sf;
	}

}
