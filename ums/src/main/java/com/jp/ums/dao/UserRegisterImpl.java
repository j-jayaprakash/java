package com.jp.ums.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jp.ums.dto.RegisterDto;
import com.jp.ums.entity.Register;
import com.jp.ums.util.ConnectionPropertiesUtil;

public class UserRegisterImpl implements UserRegister {

	@Override
	public void saveRegisterInfo(RegisterDto rdto) {
		
		Register register = new Register();
		register.setCity(rdto.getCity());
		register.setContactNumber(rdto.getContactNumber());
		register.setEmail(rdto.getEmail());
		register.setFirstName(rdto.getFirstName());
		register.setPinCode(rdto.getPinCode());
		
		
		Configuration config = new Configuration();
		
		config.setProperties(ConnectionPropertiesUtil.getConnectionProperties());
		config.addAnnotatedClass(Register.class);
		
		SessionFactory sf = config.buildSessionFactory();
		
		Session sesson = sf.openSession();
		
		Transaction st = sesson.beginTransaction();
		
		sesson.save(register);
		
		st.commit();
		
		
	}

}
