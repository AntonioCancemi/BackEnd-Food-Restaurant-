package com.menu.menu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menu.menu.Enitity.MenuCategory;
import com.menu.menu.Enitity.MenuItem;
import com.menu.menu.repository.MenuCategoryRepository;
import com.menu.menu.repository.MenuItemRepository;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;
    @Autowired
    private MenuCategoryRepository menuCategoryRepository;

    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    public MenuItem getMenuItemById(Long id) {
        return menuItemRepository.findById(id).orElse(null);
    }

    @Transactional
    public MenuItem createOrUpdateMenuItem(MenuItem menuItem) {
        if (menuItem.getCategory() != null) {
            // Controlla se la categoria esiste
            MenuCategory existingCategory = menuCategoryRepository.findById(menuItem.getCategory().getId()).orElse(null);

            if (existingCategory != null) {
                menuItem.setCategory(existingCategory);

                // Verifica se l'elemento del menu ha un ID, se sì, esegue un aggiornamento, altrimenti crea un nuovo elemento del menu
                if (menuItem.getId() != null) {
                    MenuItem existingMenuItem = menuItemRepository.findById(menuItem.getId()).orElse(null);
                    if (existingMenuItem != null) {
                        existingMenuItem.setName(menuItem.getName());
                        existingMenuItem.setDescription(menuItem.getDescription());
                        existingMenuItem.setPrice(menuItem.getPrice());
                        return menuItemRepository.save(existingMenuItem);
                    }
                }
                return menuItemRepository.save(menuItem);
            } else {
                throw new RuntimeException("La categoria specificata non esiste.");
            }
        } else {
            throw new RuntimeException("L'ID della categoria è obbligatorio.");
        }
    }

    public void deleteMenuItem(Long id) {
        menuItemRepository.deleteById(id);
    }
}
