package com.co.StreetFood.StreetFood.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.co.StreetFood.StreetFood.Entity.ProductosEntity;
import com.co.StreetFood.StreetFood.Entity.UsersEntity;
import com.co.StreetFood.StreetFood.Manager.LoginManager;
import com.co.StreetFood.StreetFood.Manager.ProductosManager;

import jakarta.transaction.Transactional;

@RestController
public class StreetFoodService {
	
	@Autowired
	private LoginManager loginManager;
	
	@Autowired
	private ProductosManager productosManager;

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
	
	@GetMapping("/getProducts")
	@ResponseBody
	public List<ProductosEntity> getProducts() {
		return productosManager.getProducts();
	}
	
	@PostMapping("/postProductos")
	@Transactional
	public void addProduct(@RequestBody ProductosEntity product) {
		productosManager.addProduct(product);
	}
	
	@PutMapping("/putProductos")
	@Transactional
	public void updateProduct(@RequestBody ProductosEntity product) {
		productosManager.updateProduct(product);
	}
	
	@DeleteMapping("/deleteProductos/{nombre}")
	@Transactional
	public void deleteProduct(@PathVariable String nombre) {
		productosManager.deleteProduct(nombre);
	}
}
