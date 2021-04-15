package com.basma.categorie.ressource;

import com.basma.categorie.entity.Category;
import com.basma.categorie.entity.HttpResponse;
import com.basma.categorie.repository.CategoryRepository;
import com.basma.categorie.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class CategoryController {

    public static final String CATEGORY_DELETED_SUCCESSFULLY = "Category deleted successfully";

    @Autowired
    CategoryService categoryService;


    @PostMapping("/saveCategory")
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
    //@PreAuthorize("hasAnyAuthority('user:delete')")
    public ResponseEntity<HttpResponse> deleteCategory(@PathVariable("name") String name) throws IOException {
        categoryService.deleteCategory(name);
        return response(OK, CATEGORY_DELETED_SUCCESSFULLY);
    }


    @PostMapping("/update")
    public ResponseEntity<Category> update(@RequestParam("newname") String newname,
                                       @RequestParam("name") String name
                                       ) {
        Category category = categoryService.updateCategory(newname, name);
        return new ResponseEntity<>(category, OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getCategories();
        return new ResponseEntity<>(categories, OK);
    }


}
