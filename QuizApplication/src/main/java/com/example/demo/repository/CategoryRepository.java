package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.category;

import jakarta.transaction.Transactional;

public interface CategoryRepository extends JpaRepository<category, Long> {
	
	
	/*
	 * @Transactional
	 * 
	 * @Modifying
	 * 
	 * @Query("DELETE FROM questions WHERE category_id = ?") void deleteById(Long
	 * Id);
	 */
	
 

}
