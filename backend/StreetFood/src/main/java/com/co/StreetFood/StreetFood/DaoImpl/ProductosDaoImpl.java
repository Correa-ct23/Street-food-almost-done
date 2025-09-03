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

	@Override
	public void addProduct(ProductosEntity product) {
		entityManager.persist(product);
		entityManager.flush();
	}

	@Override
	public void updateProduct(ProductosEntity product) {
		entityManager.merge(product);
		entityManager.flush();
	}
	
	@Override
	public ProductosEntity getProductByName(String name){
		try {
			return entityManager
				    .createQuery("SELECT u FROM ProductosEntity u WHERE u.nombre = :nombre", ProductosEntity.class)
				    .setParameter("nombre", name)
				    .getSingleResult();
		}
		catch(Exception e){
			  return null;
		}
	}

	@Override
	public void deleteProduct(ProductosEntity product) {
		entityManager.remove(product);
		entityManager.flush();
	}
}
