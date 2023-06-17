package org.jsp.productbootapp.controller;

import java.util.List;

import org.jsp.productbootapp.dto.Product;
import org.jsp.productbootapp.dto.ResponseStructure;
import org.jsp.productbootapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController 
{
	@Autowired
	private ProductService service;
	
	@PostMapping("/products")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product p)
	{
		return service.saveProduct(p);
	}
	
	@PutMapping("/products")
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product p)
	{
		return service.updateProduct(p);
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<ResponseStructure<Product>> findProduct(@PathVariable int id)
	{
		return service.findProduct(id);
	}
	
	@GetMapping("/products")
	public ResponseEntity<ResponseStructure<List<Product>>> findAll()
	{
		return service.findAll();
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteProduct(@PathVariable int id)
	{
		return service.deleteProduct(id);
	}
	
	@PostMapping("/products/verify")
	public ResponseEntity<ResponseStructure<Product>> verifyProduct(@RequestParam int id,@RequestParam String name)
	{
		return service.verifyProduct(id, name);
	}
}
