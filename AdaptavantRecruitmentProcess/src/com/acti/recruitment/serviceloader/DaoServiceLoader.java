package com.acti.recruitment.serviceloader;

import java.util.List;

import com.acti.recruitment.dto.UserDetails;

public interface DaoServiceLoader {
	public void savePojo(UserDetails user);
	public List<UserDetails> getPojo(String user_Name);
	public List<UserDetails> getAll();
	public List<UserDetails> getPojoByField(String field,String fieldValue);
	//public List<UserDetails> changePassword(String username,String old_Password);
}
