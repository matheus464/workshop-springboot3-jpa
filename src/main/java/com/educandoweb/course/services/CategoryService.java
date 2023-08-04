package com.educandoweb.course.services;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<Category> findAll(){
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList;
    }

    @Transactional(readOnly = true)
    public Category findById(Long id){
        Optional<Category> category = categoryRepository.findById(id);
        return category.get();
    }
}
