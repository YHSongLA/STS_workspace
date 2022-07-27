package com.yhsong.yardiproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yhsong.yardiproject.models.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long>{
	// FIND ALL
	List<Cart> findAll();
}
