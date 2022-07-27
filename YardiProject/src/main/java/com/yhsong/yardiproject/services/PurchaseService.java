package com.yhsong.yardiproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yhsong.yardiproject.models.Purchase;
import com.yhsong.yardiproject.repositories.PurchaseRepository;

@Service
public class PurchaseService {
	@Autowired
	PurchaseRepository purchaseRepo;
	
	// CREATE RELATIONSHIP
	public Purchase createRelationship(Purchase newPurchase) {
		return purchaseRepo.save(newPurchase);
	}
	
	// GET ALL PURCHASES
	public List<Purchase> getAllPurchases() {
		return purchaseRepo.findAll();
	}
}
