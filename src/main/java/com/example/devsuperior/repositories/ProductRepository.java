package com.example.devsuperior.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.devsuperior.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	

}
