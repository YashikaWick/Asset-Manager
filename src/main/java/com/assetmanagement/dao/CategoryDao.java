package com.assetmanagement.dao;

import com.assetmanagement.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryDao extends JpaRepository<Category, Integer> {

    @Query(value="SELECT new Category (c.id,c.name) FROM Category c")
    List<Category> list();
}
