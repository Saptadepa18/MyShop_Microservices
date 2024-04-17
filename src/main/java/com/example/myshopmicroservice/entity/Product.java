package com.example.myshopmicroservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity 
@Data
@Embeddable
public class Product {
	
	@Id
	private int id;
	
	@Column
	private String title;
	@Column
	private double price;
	@Column
	private String description;
	@Column
	private String category;
	@Column
	private String image;
	@Column 
	private int availability;

}
