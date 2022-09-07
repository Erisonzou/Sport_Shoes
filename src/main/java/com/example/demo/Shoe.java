package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Shoe {
	
	@Id
	private String Name;
	private int Price;
	private String Brand;
	private int Size;
	private int Quantity;
	
}
