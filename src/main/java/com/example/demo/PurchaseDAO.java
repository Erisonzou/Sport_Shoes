package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseDAO {
	
	@Autowired
	PurchaseRepo pRepo;
	
	public List<Purchase>getallPurchase(String user){
		
		List<Purchase> s = pRepo.findAll();
		
		List<Purchase> ss = new ArrayList<Purchase>(); 
		
		for (Purchase item:s) {
			if(item.getUser().equals(user)) {
				ss.add(item);
			}
		}
		return ss;
	}
	
	public Purchase insertPurchase(Purchase s) {
		return pRepo.save(s);
	}
}
