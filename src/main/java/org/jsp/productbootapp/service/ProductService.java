package org.jsp.productbootapp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.productbootapp.dao.ProductDao;
import org.jsp.productbootapp.dto.Product;
import org.jsp.productbootapp.dto.ResponseStructure;
import org.jsp.productbootapp.exception.InvalidCredentialsException;
import org.jsp.productbootapp.exception.ProductIdNotFoundFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService 
{
	@Autowired
	private ProductDao dao;
	
	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product p)
	{
		ResponseStructure<Product> str = new ResponseStructure<Product>();
		str.setMessage("Product Registered Succesfully");
		str.setBody(dao.saveProduct(p));
		str.setCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Product>>(str,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Product>> updateProduct(Product p)
	{
		ResponseStructure<Product> str = new ResponseStructure<Product>();
		str.setMessage("Product Updated Succesfully");
		str.setBody(dao.updateProduct(p));
		str.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Product>>(str,HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<Product>> findProduct(int id)
	{
		ResponseStructure<Product> str = new ResponseStructure<Product>();
		Optional<Product> recProduct = dao.findProduct(id);
		if(recProduct.isPresent())
		{
			str.setMessage("Product Found");
			str.setBody(recProduct.get());
			str.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Product>>(str,HttpStatus.OK);
		}
		throw new ProductIdNotFoundFoundException();
	}
	
	public  ResponseEntity<ResponseStructure<List<Product>>> findAll()
	{
		ResponseStructure<List<Product>> str = new ResponseStructure<List<Product>>();
		str.setMessage("All Products are Displayed :");
		str.setBody(dao.findAll());
		str.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Product>>>(str,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteProduct(int id)
	{
		ResponseStructure<String> str = new ResponseStructure<String>();
		Optional<Product> recProduct = dao.findProduct(id);
		if(recProduct.isPresent())
		{
			dao.deleteProduct(id);
			str.setMessage("Product Found");
			str.setBody("Product Deleted");
			str.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(str,HttpStatus.OK);
		}
		str.setMessage("Product Not Found");
		str.setBody("Product Not Deleted");
		str.setCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(str,HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<ResponseStructure<Product>> verifyProduct(int id, String name)
	{
		ResponseStructure<Product> str = new ResponseStructure<Product>();
		Optional<Product> recProduct = dao.verifyProduct(id, name);
		if(recProduct.isPresent())
		{
			str.setBody(recProduct.get());
			str.setCode(HttpStatus.OK.value());
			str.setMessage("Product Verified");
			return new ResponseEntity<ResponseStructure<Product>>(str,HttpStatus.OK);
		}
		throw new InvalidCredentialsException();
	}
}
