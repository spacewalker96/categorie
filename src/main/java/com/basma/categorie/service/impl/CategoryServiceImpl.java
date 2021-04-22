package com.basma.categorie.service.impl;

import com.basma.categorie.entity.Category;
import com.basma.categorie.repository.CategoryRepository;
import com.basma.categorie.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }



    @Override
    public Category findCategoryByName(String name) {
        return categoryRepository.findCategoryByName(name);
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(String name) {
        Category category= categoryRepository.findCategoryByName(name);
        categoryRepository.deleteById(category.getId());

    }
//
//    @Override
//    public Category updateCategory(String newname,String name) {
//        Category category= categoryRepository.findCategoryByName(name);
//        category.setName(newname);
//        categoryRepository.save(category);
//        return category;
//    }
}
