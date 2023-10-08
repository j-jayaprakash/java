package com.jp.hibernate_mapping.entity;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class SystemDao {
	
	public void saveSystemDetails(SystemC system) {
		
		
		Session openSession = SessonFactoryGenarator.getSessionFactory().openSession();
		Transaction tr = openSession.beginTransaction();
		
		openSession.merge(system);
		
		tr.commit();
		
		
	}

}
