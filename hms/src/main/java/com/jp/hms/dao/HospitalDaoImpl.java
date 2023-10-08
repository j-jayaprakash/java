package com.jp.hms.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.jp.hms.dto.AppoinmentDto;
import com.jp.hms.dto.DoctorDto;
import com.jp.hms.dto.UserDto;
import com.jp.hms.entity.Appointment;
import com.jp.hms.entity.Doctor;
import com.jp.hms.entity.User;
import com.jp.hms.util.SessonFactoryGen;

public class HospitalDaoImpl<T> implements HospitalDao<T> {

	@Override
	public Object create(T obj) {

		Session session = SessonFactoryGen.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		T docOrPat = null;

		if (obj instanceof DoctorDto) {

			DoctorDto docDto = (DoctorDto) obj;
			Doctor doctor = new Doctor();

			doctor.setName(docDto.getName());
			doctor.setEmail(docDto.getEmail());
			doctor.setConatact(docDto.getConatact());
			doctor.setType(docDto.getType());
			doctor.setAvailableTime(docDto.getAvailableTime());

			docOrPat = (T) doctor;

		} else if (obj instanceof UserDto) {

			UserDto userDto = (UserDto) obj;

			User user = new User();

			user.setName(userDto.getName());
			user.setContact(userDto.getContact());
			user.setEmail(userDto.getEmail());

			docOrPat = (T) user;

		} else {
			System.out.println("invalid obj");
		}

		Object savedObj = session.merge(docOrPat);

		transaction.commit();

		return savedObj;
	}

	@Override
	public String bookAppointMent(AppoinmentDto appointmetDto) {
		Session session = SessonFactoryGen.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		List<Appointment> currentAppoinmments = getAllAppointmentOfADoctorByDate(appointmetDto.getDid(),
				appointmetDto.getAppointmentDate());

		if (currentAppoinmments.size() < 4) {

			Doctor doc = session.find(Doctor.class, appointmetDto.getDid());

			String[] availTime = doc.getAvailableTime().split(",");

			for (String time : availTime) {
				if (Integer.parseInt(time) == appointmetDto.getTime()) {

					for (Appointment obj : currentAppoinmments) {

						if (obj.getTime() == appointmetDto.getTime())
							return "this time slat already booked select another slat";

					}
				}
			}

			Appointment appointment = new Appointment();

			appointment.setAppointmentDate(appointmetDto.getAppointmentDate());
			appointment.setDid(appointmetDto.getDid());
			appointment.setPid(appointmetDto.getPid());
			appointment.setRemark(appointmetDto.getRemark());

			Object savedObj = session.save(appointment);
			transaction.commit();

			return "booked successfully" + savedObj;

		}
		return "appointment full";
	}

	@Override
	public int updateContactByEmail(String email, String contact) {

		Session session = SessonFactoryGen.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		String s = "update User set contact=:con where email=:em";

		Query q = session.createQuery(s);

		q.setParameter("em", email);
		q.setParameter("con", contact);

		int res = q.executeUpdate();

		transaction.commit();

		return res;
	}

	@Override
	public int updateRemarksByPatientId(long patientId, String remarks) {

		Session session = SessonFactoryGen.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		String s = "update Appointment set remark=:rem where id=:pid";

		Query q = session.createQuery(s);

		q.setParameter("rem", remarks);
		q.setParameter("pid", patientId);

		int res = q.executeUpdate();
		transaction.commit();

		return res;
	}

	@Override
	public List getAllAppointmentsByDoctorId(int doctorId) {

		Session session = SessonFactoryGen.getSessionFactory().openSession();

		String s = "from Appointment where id=:did";

		Query q = session.createQuery(s);
		q.setParameter("did", doctorId);
		List resultList = q.getResultList();

		return resultList;
	}

	@Override
	public List getAllAppointmentOfADoctorByDate(int doctorId, Date date) {

		Session session = SessonFactoryGen.getSessionFactory().openSession();

		String s = "from Appointment where appointmentDate=:ad and did=:docid";

		Query q = session.createQuery(s);
		q.setParameter("ad", date);
		q.setParameter("docid", doctorId);
		List resultList = q.getResultList();

		return resultList;
	}
	
	
	
	private boolean checkAvailablity(AppoinmentDto appointmentDet) {

		List currentAppoinmments = getAllAppointmentOfADoctorByDate(appointmentDet.getDid(),
				appointmentDet.getAppointmentDate());

		if (currentAppoinmments.size() < 4) {

			Doctor doc = SessonFactoryGen.getSessionFactory().openSession().find(Doctor.class, appointmentDet.getDid());

			String[] availTime = doc.getAvailableTime().split(",");

			for (String time : availTime) {

				if (Integer.parseInt(time) == appointmentDet.getTime()) {
					for (Object obj : currentAppoinmments) {

						Appointment app = (Appointment) obj;

						if (app.getTime() == appointmentDet.getTime()) {
							System.out.println("time slat already booked");
							return false;
						}
					}
				}

			}

			System.out.println("for this day appointment is full");
			return false;
		}
		return true;

	}

}
