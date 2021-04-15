package com.basma.categorie.service;

import com.basma.categorie.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getCategories();
    Category findCategoryByName(String name);
    Category saveCategory(Category category);
    public void deleteCategory(String name) ;
    Category updateCategory(String newname,String name) ;
}
