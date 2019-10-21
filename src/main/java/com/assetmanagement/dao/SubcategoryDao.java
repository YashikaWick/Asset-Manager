package com.assetmanagement.dao;

import com.assetmanagement.entity.Category;
import com.assetmanagement.entity.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sun.security.provider.Sun;

import java.util.List;

public interface SubcategoryDao extends JpaRepository<Subcategory, Integer> {
    @Query(value="SELECT new Subcategory(e.id,e.name,e.categoryId) FROM Subcategory e where e.categoryId.id=:categoryId")
    List<Subcategory> listByCategory(@Param("categoryId") Integer categoryId);
}
