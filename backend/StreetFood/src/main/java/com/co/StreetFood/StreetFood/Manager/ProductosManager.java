package com.co.StreetFood.StreetFood.Manager;

import java.util.List;

import com.co.StreetFood.StreetFood.Entity.ProductosEntity;

public interface ProductosManager {

	List<ProductosEntity> getProducts();
	
	void addProduct(ProductosEntity product);
	
	void updateProduct(ProductosEntity product);
	
	void deleteProduct(String name);
}
