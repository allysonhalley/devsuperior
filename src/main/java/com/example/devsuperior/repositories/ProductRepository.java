package com.example.devsuperior.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.devsuperior.entities.Product;

@Component 
public class ProductRepository {
	
	private Map<Long, Product> map = new HashMap<>();
	
	public void save(Product obj) {
		
		map.put(obj.getId(), obj);
		
	}
	
	public Product findById(Long id) {		
		
		return map.get(id);
		
	}
	
	public List<Product> findAll(){
		
		return new ArrayList<Product>(map.values());
		
	}

	
	
//	public Map<Long, Category> getMap() {
//		return map;
//	}
//
//	public void setMap(Map<Long, Category> map) {
//		this.map = map;
//	}
}
