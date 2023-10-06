package com.jp.hms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.jp.hms.dao.HospitalDaoImpl;
import com.jp.hms.dto.AppoinmentDto;
import com.jp.hms.dto.DoctorDto;
import com.jp.hms.dto.UserDto;
import com.jp.hms.entity.Appointment;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws ParseException {

		HospitalDaoImpl<DoctorDto> doctorImpl = new HospitalDaoImpl<DoctorDto>();
		HospitalDaoImpl<UserDto> userImpl = new HospitalDaoImpl<UserDto>();
		HospitalDaoImpl genImpl = new HospitalDaoImpl();

		// insert doctor
		DoctorDto doctor = new DoctorDto();

		doctor.setName("prakash");
		doctor.setConatact("9876543210");
		doctor.setEmail("prakash@outlook.com");
		doctor.setType("general");
		doctor.setAvailableTime("10,12");
		
		System.out.println("==============================================================");

		System.out.println(

				doctorImpl.create(doctor)

		);
		System.out.println("==============================================================");

		// inser user

		UserDto user = new UserDto();

		user.setName("dharani");
		user.setEmail("dharani@outlook.com");
		user.setContact("679023457");
		
		
		System.out.println("==============================================================");
		System.out.println(

				userImpl.create(user)

		);
		System.out.println("==============================================================");
		
		AppoinmentDto appointment = new AppoinmentDto();
		
		Date date=new SimpleDateFormat("dd-MM-yyyy").parse("07-10-2023");
		appointment.setAppointmentDate(date);
		appointment.setDid(1);
		appointment.setPid(1);
		appointment.setRemark(null);
		
		
		String appointmentres = genImpl.bookAppointMent(appointment);
		
		System.out.println("==============================================================");

		System.out.println(appointmentres);
		
		System.out.println("==============================================================");
		
		
		List allAppointmentOfADoctorByDate = userImpl.getAllAppointmentOfADoctorByDate(date);
		
		for (Object object : allAppointmentOfADoctorByDate) {
			
			System.out.println(object);
			
		}
		
		
		int updateContactByEmail = genImpl.updateContactByEmail("dharani@outlook.com", "764321876");
		
		System.out.println("==============================================================");
		
		System.out.println(updateContactByEmail);
		
		System.out.println("==============================================================");
		
		
		genImpl.updateRemarksByPatientId(1, "cold");
		
		
		
		
	}
}
