package com.assetmanagement.dao;

import com.assetmanagement.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BrandDao extends JpaRepository<Brand, Integer> {

    /*@Query(value="SELECT new Brand (e.id,e.name) FROM Brand e")
    List<Brand> list();*/

    @Query(value="SELECT new Brand(b.id,b.name) FROM Brand b where b in(SELECT cb.brandId from Brandcategory cb where cb.categoryId.id=:categoryId) ")
    List<Brand> listByCategory(@Param("categoryId")Integer categoryId);

    @Query(value="SELECT new Brand(b.id,b.name) FROM Brand b")
    List<Brand> list();
}


