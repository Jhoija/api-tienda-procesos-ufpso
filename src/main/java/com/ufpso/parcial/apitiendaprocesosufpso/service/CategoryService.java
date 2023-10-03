package com.ufpso.parcial.apitiendaprocesosufpso.service;

import com.ufpso.parcial.apitiendaprocesosufpso.model.Category;
import com.ufpso.parcial.apitiendaprocesosufpso.model.Category;
import com.ufpso.parcial.apitiendaprocesosufpso.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(Category CategoryReq) {
        return categoryRepository.save(CategoryReq);
    }

    public Category getCategoryById(Long id) {
        Optional<Category> category =categoryRepository.findById(id);
        if (category.isEmpty())
            return null;
        return category.get();
    }

    public List<Category> getAllCategory() {
        return (List<Category>) categoryRepository.findAll();
    }

    public Category updateCategory(Category CategoryReq, Long id) {
        Optional<Category> CategoryDB = categoryRepository.findById(id);
        if (CategoryDB.isEmpty()) {
            return null;
        }
        return categoryRepository.save(CategoryDB.get());
    }

    public boolean deleteCategory(Long id) {
        Optional<Category> CategoryDB = categoryRepository.findById(id);
        if (CategoryDB.isEmpty()) {
            return false;
        }
        categoryRepository.delete(CategoryDB.get());
        return true;
    }
}
