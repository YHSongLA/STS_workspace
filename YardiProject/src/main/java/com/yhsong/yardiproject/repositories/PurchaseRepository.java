package com.yhsong.yardiproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yhsong.yardiproject.models.Purchase;

@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, Long>{
	List<Purchase> findAll();
}
