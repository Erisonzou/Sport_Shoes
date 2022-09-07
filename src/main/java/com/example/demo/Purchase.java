package com.example.demo;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class Purchase {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private LocalDateTime time;
	private String user;	
	private String ShoeName;
	private int ShoePrice;
	private String ShoeBrand;
	private int ShoeSize;
	
	
}
