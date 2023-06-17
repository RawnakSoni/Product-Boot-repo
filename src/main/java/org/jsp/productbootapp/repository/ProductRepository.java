package org.jsp.productbootapp.repository;

import java.util.Optional;

import org.jsp.productbootapp.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product,Integer>
{
	@Query("select p from Product p where p.id=?1 and p.name=?2")
	Optional<Product> verifyProduct(int id, String name);
}

