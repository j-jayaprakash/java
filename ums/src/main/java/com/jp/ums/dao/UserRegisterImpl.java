package com.jp.ums.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.jp.ums.dto.RegisterDto;
import com.jp.ums.entity.Register;
import com.jp.ums.util.SessonFactoryGenarator;

public class UserRegisterImpl implements UserRegister {

	private Session getSesson() {
		SessionFactory sf = SessonFactoryGenarator.getSessionFactory();
		Session sesson = sf.openSession();
		return sesson;

	}

	@Override
	public void saveRegisterInfo(RegisterDto rdto) {

		Register register = new Register();
		register.setCity(rdto.getCity());
		register.setContactNumber(rdto.getContactNumber());
		register.setEmail(rdto.getEmail());
		register.setFirstName(rdto.getFirstName());
		register.setPinCode(rdto.getPinCode());

		Session sesson = getSesson();
		Transaction st = sesson.beginTransaction();

		sesson.save(register);
		st.commit();
	}

	@Override
	public Register getUserById(long altKey) {

		Register user = getSesson().find(Register.class, altKey);

		return user;

	}

	@Override
	public boolean updateRegisterInfo(long altKey, String phone, String email) {

		Register user = getUserById(altKey);

		if (user != null) {
			user.setEmail(email);
			user.setContactNumber(phone);

			Session sesson = getSesson();

			Transaction st = sesson.beginTransaction();
			sesson.merge(user);
			st.commit();
			return true;

		}

		return false;
	}

	public void deleteRegister(long altKey) {

		Session sesson = SessonFactoryGenarator.getSessionFactory().openSession();
		Register reg = getUserById(altKey);
		sesson.remove(reg);
	}

	@Override
	public List<Register> findAll() {

		Session sesson = SessonFactoryGenarator.getSessionFactory().openSession();
		StringBuilder sb = new StringBuilder();
		sb.append("from Register");

		Query q = sesson.createQuery(sb.toString());

		return q.getResultList();
	}

	public void display(List<Register> register) {

		register.forEach((each) -> {
			System.out.println(each);
		});
	}

	@Override
	public List<Register> findByCity(String city) {
		Session sesson = SessonFactoryGenarator.getSessionFactory().openSession();
		StringBuilder sb = new StringBuilder();
		sb.append("from Register where city =:c");

		Query q = sesson.createQuery(sb.toString());
		q.setParameter("c", city);

		return q.getResultList();
	}

	@Override
	public Register getByEmailPincode(String email, String pincode) {

		Session session = SessonFactoryGenarator.getSessionFactory().openSession();

		StringBuilder sb = new StringBuilder();

		sb.append("from Register where email=:email and pinCode=:pc");

		Query query = session.createQuery(sb.toString());

		query.setParameter("email", email);
		query.setParameter("pc", pincode);

		return (Register) query.uniqueResult();
	}

	@Override
	public int setByEmailPincodeCity(String email, String pincode, String city) {

		Session session = SessonFactoryGenarator.getSessionFactory().openSession();
		Transaction rt = session.beginTransaction();

		StringBuilder sb = new StringBuilder();

		sb.append("update Register set email=:email,pinCode=:pc,city=:c where email=:email");

		Query query = session.createQuery(sb.toString());

		query.setParameter("email", email);
		query.setParameter("pc", pincode);
		query.setParameter("c", city);

		int res = query.executeUpdate();

		rt.commit();
		return res;
	}

	@Override
	public int deleteRegByEmail(String email) {
		Session session = SessonFactoryGenarator.getSessionFactory().openSession();
		Transaction rt = session.beginTransaction();
		StringBuilder sb = new StringBuilder();
		sb.append("delete from Register where email=:email");
		Query query = session.createQuery(sb.toString());
		query.setParameter("email", email);
		int res = query.executeUpdate();
		rt.commit();
		return res;
	}

}
