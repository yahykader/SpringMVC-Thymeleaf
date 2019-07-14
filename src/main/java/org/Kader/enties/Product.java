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

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Product implements Serializable{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min=2,max=15,message = "le nom doit être entre 2 et 15 caractére")
	private String nom;

	@NotNull
	@Size(min=10,max=100,message = "le description doit être entre 10 et 100 caractére")
	private String description;

	@NotNull
	@Size(min=4,max=25,message = "le designation doit être entre 4 et 25 caractére")
	private String designation;

	@DecimalMin("100")
	private double prix;

	@DecimalMin("1")
	private int quantite;
    @NotEmpty(message = "Email n'est doit pas être vide")
	@Email(regexp = "^(.+)@(.+)$",message = "email n'est pas correcte")
	private String email;

	//@FutureOrPresent
	//@Future
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date=new Date();

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
