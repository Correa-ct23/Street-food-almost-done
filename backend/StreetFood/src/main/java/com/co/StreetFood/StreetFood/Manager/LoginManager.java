package com.co.StreetFood.StreetFood.Manager;

import java.util.List;

import com.co.StreetFood.StreetFood.Entity.UsersEntity;

public interface LoginManager {

	List<UsersEntity> getUsers();

	void addUser(UsersEntity user);
	
}
