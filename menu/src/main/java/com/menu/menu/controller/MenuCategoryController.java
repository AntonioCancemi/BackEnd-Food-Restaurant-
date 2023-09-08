package com.menu.menu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.menu.menu.Enitity.MenuCategory;
import com.menu.menu.service.MenuCategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class MenuCategoryController {

    @Autowired
    private MenuCategoryService categoryService;

    @GetMapping
    public List<MenuCategory> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public MenuCategory getCategoryById(@PathVariable long id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    public MenuCategory createCategory(@RequestBody MenuCategory category) {
        return categoryService.createCategory(category);
    }

    @PutMapping("/{id}")
    public MenuCategory updateCategory(@PathVariable long id, @RequestBody MenuCategory updatedCategory) {
        return categoryService.updateCategory(id, updatedCategory);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable long id) {
        categoryService.deleteCategory(id);
    }
}
