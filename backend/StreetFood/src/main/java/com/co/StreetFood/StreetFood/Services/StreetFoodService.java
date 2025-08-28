package com.co.StreetFood.StreetFood.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.co.StreetFood.StreetFood.Entity.UsersEntity;
import com.co.StreetFood.StreetFood.Manager.LoginManager;

import jakarta.transaction.Transactional;

@RestController
public class StreetFoodService {
	
	@Autowired
	private LoginManager loginManager;

	@GetMapping("/Login")
	@ResponseBody
	public List<UsersEntity> Login() {
		return loginManager.getUsers();
	}
	
	@PostMapping("/SignUp")
	@Transactional
	public void addUser(@RequestBody UsersEntity user) {
		loginManager.addUser(user);
	}
}
