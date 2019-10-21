package com.assetmanagement.dao;

import com.assetmanagement.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SupplierDao extends JpaRepository<Supplier, Integer> {

    @Query(value="SELECT new Supplier (s.id,s.companyName) FROM Supplier s")
    List<Supplier> list();

    @Query("SELECT s FROM Supplier s WHERE s.regno= :regno")
    Supplier findByRegno(@Param("regno")Integer regno);

}
