package com.basma.categorie.ressource;

import com.basma.categorie.entity.Category;
import com.basma.categorie.entity.HttpResponse;
import com.basma.categorie.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/category")
public class CategoryController {

    public static final String CATEGORY_DELETED_SUCCESSFULLY = "Category deleted successfully";
    public static final String CATEGORY_UPDATED_SUCCESSFULLY = "Category updated successfully";


    @Autowired
    CategoryService categoryService;


    @PostMapping("/save")
    public ResponseEntity<Category> save(@RequestBody Category category) {
        Category newCategory = categoryService.saveCategory(category);
        return new ResponseEntity<>(newCategory, OK);
    }


    @GetMapping("/find/{name}")
    public ResponseEntity<Category> getCategory(@PathVariable("name") String name) {
        Category category = categoryService.findCategoryByName(name);
        return new ResponseEntity<>(category, OK);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(),
                message), httpStatus);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<HttpResponse> deleteCategory(@PathVariable("name") String name) throws IOException {
        categoryService.deleteCategory(name);
        return response(OK, CATEGORY_DELETED_SUCCESSFULLY);
    }


    @PutMapping("/update/{name}")
    ResponseEntity<HttpResponse> updateCtegory(@RequestBody Category category, @PathVariable String name) {
    Category categoryUpdated = categoryService.findCategoryByName(name);
    categoryUpdated.setName(category.getName());
    categoryService.saveCategory(categoryUpdated);
    return response(ACCEPTED, CATEGORY_UPDATED_SUCCESSFULLY);
    }


    @GetMapping("/list")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getCategories();
        return new ResponseEntity<>(categories, OK);
    }


}
