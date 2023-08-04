package com.educandoweb.course.resource;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> categoryResult = categoryService.findAll();
        return ResponseEntity.ok().body(categoryResult);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category ctg = categoryService.findById(id);
        return ResponseEntity.ok().body(ctg);
    }
}
