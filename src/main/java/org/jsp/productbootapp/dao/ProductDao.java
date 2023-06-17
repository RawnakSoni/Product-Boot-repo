package org.jsp.productbootapp.dao;

import java.util.List;
import java.util.Optional;
import org.jsp.productbootapp.dto.Product;
import org.jsp.productbootapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao 
{
	@Autowired
	private ProductRepository repo;
	
	public Product saveProduct(Product p)
	{
		return repo.save(p);
	}
	
	public Product updateProduct(Product p)
	{
		return repo.save(p);
	}
	
	public Optional<Product> findProduct(int id)
	{
		return repo.findById(id);
	}
	
	public List<Product> findAll()
	{
		return repo.findAll();
	}
	
	public void deleteProduct(int id)
	{
		repo.deleteById(id);
	}
	
	public Optional<Product> verifyProduct(int id, String name)
	{
		return repo.verifyProduct(id, name);
	}
}
