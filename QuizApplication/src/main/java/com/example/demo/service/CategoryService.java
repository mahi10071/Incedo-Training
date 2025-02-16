package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.category;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<category> getAllCategories() {
        return categoryRepository.findAll(); // Fetch all categories from the DB
    }
    
    public category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }


	  public void deleteCategory(Long categoryId) throws Exception {
		  Optional<category> category = categoryRepository.findById(categoryId);
	        if (category.isPresent()) {
	            categoryRepository.deleteById(categoryId); // Delete the category
	        } else {
	            throw new Exception("Category not found");
	        }
	    }


	public void saveCategory(category category) {
		// TODO Auto-generated method stub
		 categoryRepository.save(category); 
		
	}
}

