package com.co.StreetFood.StreetFood.DaoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.co.StreetFood.StreetFood.Dao.ProductosDao;
import com.co.StreetFood.StreetFood.Entity.ProductosEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ProductosDaoImpl implements ProductosDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<ProductosEntity> getProducts() {
		return entityManager.createQuery("SELECT u FROM ProductosEntity u", ProductosEntity.class).getResultList();
	}

}
