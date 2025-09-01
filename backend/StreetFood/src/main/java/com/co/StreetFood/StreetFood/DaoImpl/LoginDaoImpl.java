package com.co.StreetFood.StreetFood.DaoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.co.StreetFood.StreetFood.Dao.LoginDao;
import com.co.StreetFood.StreetFood.Entity.UsersEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class LoginDaoImpl implements LoginDao {
	

    @PersistenceContext
    private EntityManager entityManager;

	@Override
	public List<UsersEntity> getUsers() {
		return entityManager.createQuery("SELECT u FROM UsersEntity u", UsersEntity.class).getResultList();
	}
	
	@Override
	public void addUser(UsersEntity user) {
		entityManager.persist(user);
		entityManager.flush();
	}

}
