package com.co.StreetFood.StreetFood.ManagerImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.StreetFood.StreetFood.Dao.ProductosDao;
import com.co.StreetFood.StreetFood.Entity.ProductosEntity;
import com.co.StreetFood.StreetFood.Manager.ProductosManager;

@Service
public class ProductosManagerImpl implements ProductosManager {

	@Autowired
    private ProductosDao dao;
	
	@Override
	public List<ProductosEntity> getProducts(){
		return dao.getProducts();
	}
}
