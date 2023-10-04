package com.jp.ums.dao;

import java.util.List;

import com.jp.ums.dto.RegisterDto;
import com.jp.ums.entity.Register;

public interface UserRegister {
	
	
	
	void saveRegisterInfo(RegisterDto rdto);
	
	

	Register getUserById(long altKey);
	
	boolean updateRegisterInfo(long altKey,String phone,String email);
	
	void deleteRegister(long altKey);
	
	List<Register>  findAll();
	
	List<Register>  findByCity(String city);
	


}
