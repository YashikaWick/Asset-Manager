package com.assetmanagement.dao;

import com.assetmanagement.entity.Supplierstatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SupplierStatusDao extends JpaRepository<Supplierstatus,Integer> {

    @Query(value="SELECT new Supplierstatus (s.id,s.name) FROM Supplierstatus s")
    List<Supplierstatus> list();

}
