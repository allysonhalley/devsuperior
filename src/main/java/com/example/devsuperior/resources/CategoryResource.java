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

import com.example.devsuperior.entities.Category;
import com.example.devsuperior.repositories.CategoryRepository;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll()	{
		
		List<Category> list = categoryRepository.findAll();		
		
		return ResponseEntity.ok().body(list);		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		
		Category cat = categoryRepository.findById(id).get();
		
		return ResponseEntity.ok().body(cat);
	}
	
	@PostMapping(path = "/category", consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public void addCategory(@RequestBody Category category) {
		
		categoryRepository.save(category);
		
	}
	
	
}
