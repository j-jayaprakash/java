package com.jp.ums.dao;

import com.jp.ums.dto.RegisterDto;
import com.jp.ums.entity.Register;

public interface UserRegister {
	
	
	
	void saveRegisterInfo(RegisterDto rdto);
	
	

	Register getUserById(long altKey);
	
	boolean updateRegisterInfo(long altKey,String phone,String email);

}
