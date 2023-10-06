package com.jp.hms.dao;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.jp.hms.dto.AppoinmentDto;

public interface HospitalDao<T> {
	

	
	int updateContactByEmail(String email,String contact);
	
	int updateRemarksByPatientId(long patientId,String remarks);
	
	List getAllAppointmentsByDoctorId(int doctorId);
	
	String bookAppointMent(AppoinmentDto appointmetDto);
	
	List getAllAppointmentOfADoctorByDate(Date date);

	Object create(T obj);

	


	
	
	

}
