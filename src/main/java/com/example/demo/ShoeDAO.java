package com.example.demo;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoeDAO {
	
	@Autowired
	ShoeRepo Srepo;
	
	public Shoe insertShoe(Shoe s) {
		return Srepo.save(s);
	}
	
	public List<Shoe> getallShoe(){
		return Srepo.findAll();
	}
	
	public void deleteByShoeId(String id) {
		Srepo.deleteById(id);
	}
	
	public Shoe findbyId(String id) {
		List<Shoe> s = Srepo.findAll();
		Shoe ss = new Shoe();
		for (Shoe item:s) {
			if(item.getName().equals(id)) {
				ss = item;
			}
		}
		return  ss ;
	}
	
	public Shoe updateName(Shoe s) {
		Shoe ss = Srepo.findById(s.getName()).orElse(null); 
		ss.setName(s.getName());
		return Srepo.save(ss);
	}
	
	public List<Shoe>getallShoeBrand(String Brand){
		
		List<Shoe> s = Srepo.findAll();
		
		List<Shoe> ss = new ArrayList<Shoe>(); 
		
		for (Shoe item:s) {
			if(item.getBrand().equals(Brand)) {
				ss.add(item);
			}
		}
		return ss;
	}

}
