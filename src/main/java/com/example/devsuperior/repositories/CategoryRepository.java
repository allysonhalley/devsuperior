package com.example.devsuperior.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.devsuperior.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	

}
