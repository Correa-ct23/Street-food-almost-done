package com.co.StreetFood.StreetFood.ManagerImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.StreetFood.StreetFood.Dao.ProductosDao;
import com.co.StreetFood.StreetFood.Entity.ProductosEntity;
import com.co.StreetFood.StreetFood.Manager.ProductosManager;
import com.co.StreetFood.StreetFood.util.ValidationException;

@Service
public class ProductosManagerImpl implements ProductosManager {

	@Autowired
    private ProductosDao dao;
	
	@Override
	public List<ProductosEntity> getProducts(){
		return dao.getProducts();
	}

	@Override
	public void addProduct(ProductosEntity product) {
		List<ProductosEntity> productos = dao.getProducts();
		
		List<ProductosEntity> productsDuplicate = 
		productos.stream()
			 	 .filter(p -> p.getNombre().toUpperCase().equals(product.getNombre().toUpperCase()))
			 	 .toList();
		
		if(productsDuplicate.isEmpty()) dao.addProduct(product);
		else throw new ValidationException("error");
	}

	@Override
	public void updateProduct(ProductosEntity product) {
		ProductosEntity productExists = dao.getProductByName(product.getNombre());
		if(productExists==null) { 
			throw new ValidationException("error");
		} else {
			productExists.setImagen((product.getImagen() == null ? productExists.getImagen() : product.getImagen()));
			productExists.setPrecio((product.getPrecio() == 0.0 ? productExists.getPrecio() : product.getPrecio()));

			dao.updateProduct(productExists);
		}
	}

	@Override
	public void deleteProduct(String name) {
		ProductosEntity productExists = dao.getProductByName(name);
		if(productExists==null) { 
			throw new ValidationException("error");
		} else {
			dao.deleteProduct(productExists);
		}
	}
}
