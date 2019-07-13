package org.Kader;

import java.util.stream.Stream;

import org.Kader.dao.ProductRepository;
import org.Kader.enties.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMvcThymeleafApplication implements CommandLineRunner {
	
	@Autowired 
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcThymeleafApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Stream.of("Café","Thé","Lait","Eau").forEach(n->productRepository.save(new Product(n,"aaaaa","eeeeeee")));
		
		productRepository.findAll().forEach(n-> System.out.println(n.getNameProduct()));
		
	}

}
