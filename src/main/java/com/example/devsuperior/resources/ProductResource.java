package com.example.devsuperior.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.devsuperior.entities.Product;
import com.example.devsuperior.repositories.ProductRepository;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll()	{
		
		List<Product> list = productRepository.findAll();		
		
		return ResponseEntity.ok().body(list);		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		
		Product prod = productRepository.findById(id).get();
		
		return ResponseEntity.ok().body(prod);
	}
	
	@PostMapping(path = "/product", consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public void addProduct(@RequestBody Product product) {
		productRepository.save(product);
	}
	
	
}
