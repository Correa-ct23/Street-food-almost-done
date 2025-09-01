package com.co.StreetFood.StreetFood.Dao;

import java.util.List;

import com.co.StreetFood.StreetFood.Entity.UsersEntity;

public interface LoginDao {

	List<UsersEntity> getUsers();

	void addUser(UsersEntity user);
	
}
