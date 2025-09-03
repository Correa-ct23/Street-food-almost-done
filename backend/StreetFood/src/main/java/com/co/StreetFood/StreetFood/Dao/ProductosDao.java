package com.co.StreetFood.StreetFood.Dao;

import java.util.List;

import com.co.StreetFood.StreetFood.Entity.ProductosEntity;

public interface ProductosDao {

	List<ProductosEntity> getProducts();
	
	void addProduct(ProductosEntity product);
	
	void updateProduct(ProductosEntity product);

	ProductosEntity getProductByName(String name);
	
	void deleteProduct(ProductosEntity product);
}
