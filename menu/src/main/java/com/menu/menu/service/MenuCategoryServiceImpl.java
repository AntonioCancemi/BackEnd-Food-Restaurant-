package com.menu.menu.service;

import java.util.List;

import com.menu.menu.Enitity.MenuCategory;
import com.menu.menu.repository.MenuCategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuCategoryServiceImpl implements MenuCategoryService {

    @Autowired
    private MenuCategoryRepository categoryRepository;

    @Override
    public List<MenuCategory> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public MenuCategory getCategoryById(long categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }

    @Override
    public MenuCategory createCategory(MenuCategory category) {
        return categoryRepository.save(category);
    }

    @Override
    public MenuCategory updateCategory(long categoryId, MenuCategory updatedCategory) {
        MenuCategory existingCategory = categoryRepository.findById(categoryId).orElse(null);
        if (existingCategory != null) {
            existingCategory.setCategory(updatedCategory.getCategory());
            return categoryRepository.save(existingCategory);
        } else {
            return null;
        }
    }

    @Override
    public void deleteCategory(long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
