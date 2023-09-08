package com.menu.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.menu.menu.Enitity.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

}
