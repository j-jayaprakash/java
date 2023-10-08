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

		doctor.setName("vinay");
		doctor.setConatact("7894543210");
		doctor.setEmail("vinay@outlook.com");
		doctor.setType("cardio");
		doctor.setAvailableTime("11,9,1,3");

		Object docRes = doctorImpl.create(doctor);

		System.out.println("==============================================================");

		System.out.println("doctor object saved successfully " + docRes);

		System.out.println("==============================================================");

		// inser user

		UserDto user = new UserDto();

		user.setName("Ganesh");
		user.setEmail("Ganesh@outlook.com");
		user.setContact("889023457");

		Object userObj = userImpl.create(user);

		System.out.println("==============================================================");
		System.out.println("User Object saved successfully "+ userObj);

		System.out.println("==============================================================");

		// Booking Appointment
		AppoinmentDto appointment = new AppoinmentDto();

		Date date = new SimpleDateFormat("dd-MM-yyyy").parse("08-10-2023");
		appointment.setAppointmentDate(date);
		appointment.setDid(2);
		appointment.setPid(1);
		appointment.setRemark("fever");
		appointment.setTime(2);

		String appointmentres = genImpl.bookAppointMent(appointment);

		System.out.println("==============================================================");

		System.out.println("Appointment status "+ appointmentres);

		System.out.println("==============================================================");
		
		
		//Get Appointment Details by DoctorID in Date
		List allAppointmentOfADoctorByDate = userImpl.getAllAppointmentOfADoctorByDate(1, date);

		for (Object object : allAppointmentOfADoctorByDate) {

			System.out.println(object);

		}

		
		//Update User Contact By Email
		int updateContactByEmail = genImpl.updateContactByEmail("dharani@outlook.com", "764321876");

		System.out.println("==============================================================");

		System.out.println( updateContactByEmail + " user Record Updated");

		System.out.println("==============================================================");

		//Update Remarks by PatientId
		int updateRemarksByPatientId = genImpl.updateRemarksByPatientId(1, "cold");
		
		System.out.println(updateRemarksByPatientId + " record got updated");

	}
}
