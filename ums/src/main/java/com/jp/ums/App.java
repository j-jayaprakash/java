package com.jp.ums;


import com.jp.ums.dao.UserImpl;
import com.jp.ums.dao.UserRegisterImpl;
import com.jp.ums.dto.RegisterDto;
import com.jp.ums.dto.User;


public class App 
{
    public static void main( String[] args )

    {
    	
//    	User u1 = new User();
//    	
//    	u1.setName("jayaprakash");
//    	u1.setEmail("jayaprakash@gmail.com");
//    	
//    	
//    	new UserImpl().createUser(u1);
    	
//    	RegisterDto user = new RegisterDto();
//    	
//    	user.setCity("banglore");
//    	user.setContactNumber("987643210");
//    	user.setEmail("jayaprakash@gmail.com");
//    	user.setFirstName("jayaprakash");
//    	user.setPinCode("560037");
//    	
//    	
//    UserRegisterImpl uri = new	UserRegisterImpl();
//    
//    uri.saveRegisterInfo(user);
//    
    
    UserRegisterImpl userRegImp = new UserRegisterImpl();
    
    
    System.out.println(userRegImp.updateRegisterInfo(1, "9876543212", "prakash@gmail.com"));
    
    
    
    }
}
