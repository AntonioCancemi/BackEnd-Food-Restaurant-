package com.menu.menu.service;

import java.util.List;

import com.menu.menu.Enitity.MenuCategory;

public interface MenuCategoryService {
	 	List<MenuCategory> getAllCategories();
	    MenuCategory getCategoryById(long categoryId);
	    MenuCategory createCategory(MenuCategory category);
	    MenuCategory updateCategory(long categoryId, MenuCategory updatedCategory);
	    void deleteCategory(long categoryId);
}
