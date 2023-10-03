package com.ufpso.parcial.apitiendaprocesosufpso.controller;

import com.ufpso.parcial.apitiendaprocesosufpso.model.Article;
import com.ufpso.parcial.apitiendaprocesosufpso.model.Category;
import com.ufpso.parcial.apitiendaprocesosufpso.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("category/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @GetMapping("category/list")
    public ResponseEntity<List<Category>> getAllCategory() {
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    @PostMapping("category")
    public ResponseEntity<Category> create(@RequestBody Category category) {
        System.out.println(category.getClass().getName());
        return new ResponseEntity<>(categoryService.createCategory(category), HttpStatus.CREATED);
    }

    @PutMapping("category/update/{id}")
    public ResponseEntity<Category> update(@RequestBody Category category, @PathVariable Long id ) {
        return new ResponseEntity<>(categoryService.updateCategory(category,id),HttpStatus.OK);
    }

    @DeleteMapping("category/{id}")
    public ResponseEntity<List<Category>> delete(@PathVariable Long id ) {
        return new ResponseEntity(categoryService.deleteCategory(id),HttpStatus.NO_CONTENT);
    }
}
