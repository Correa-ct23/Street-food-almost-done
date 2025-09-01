package com.co.StreetFood.StreetFood.ManagerImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.co.StreetFood.StreetFood.Dao.LoginDao;
import com.co.StreetFood.StreetFood.Entity.UsersEntity;
import com.co.StreetFood.StreetFood.Manager.LoginManager;
import com.co.StreetFood.StreetFood.util.ValidationException;

@Service
public class LoginManagerImpl implements LoginManager{

	@Autowired
    private LoginDao dao;
	
	@Override
	public List<UsersEntity> getUsers(){
		return dao.getUsers();
	}
	
	@Override
	public void addUser(UsersEntity user) {
		List<UsersEntity> users = dao.getUsers();
		
		List<UsersEntity> usersDuplicate = 
			users.stream()
			 	 .filter(u -> u.getUsername().toUpperCase().equals(user.getUsername().toUpperCase()))
			 	 .toList();
		
		if(usersDuplicate.isEmpty()) dao.addUser(user);
		else throw new ValidationException("error");
	}
}
