package com.jp.ums.dao;

import com.jp.ums.dto.User;

public class UserImpl implements UserDao {

	@Override
	public void createUser(User user) {

		System.out.println(user);
		
		
		StringBuilder sb = new StringBuilder();

    	sb.append("insert into user_info");
    	sb.append("columns (`user_name`,`user_email`)");
    	sb.append("values (");
    	sb.append(user.getName());
    	sb.append(",");
    	sb.append(user.getEmail());
    	sb.append(")");
	}
	
	

}
