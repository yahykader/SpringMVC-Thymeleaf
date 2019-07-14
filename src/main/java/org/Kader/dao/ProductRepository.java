package org.Kader.dao;

import org.Kader.enties.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RestController;

@RepositoryRestController
public interface ProductRepository extends JpaRepository<Product, Long>{

     //@RestResource(path="/findByNameProductContains")

     @Query("select p from Product p where p.nom like :mc")
     public Page<Product> chercherMC(@Param("mc")String mc, Pageable pageable);
}
