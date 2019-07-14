package org.Kader.enties;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Data @AllArgsConstructor @NoArgsConstructor

@Entity
public class Product implements Serializable{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull @Size(min=2,max=15)
	private String nameProduct;

	@NotNull @Size(min=10,max=100)
	private String description;

	@NotNull @Size(min=4,max=25)
	private String designation;

	@DecimalMin("100")
	private double prix;

	@DecimalMin("1")
	private int quantite;

	@Email
	private String email;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;

	/*@FutureOrPresent
	private Date dateAller;
	@Future
	private Date dateRetour*/;
	
/*	public Product() {
		// TODO Auto-generated constructor stub
	}
	

	public Product(String nameProduct, String description, String designation,String email,Date date,) {
		super();
		this.nameProduct = nameProduct;
		this.description = description;
		this.designation = designation;
		this.email=email;
		this.date=date;
	}*/


}
