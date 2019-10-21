package com.assetmanagement.dao;

import com.assetmanagement.entity.Asset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AssetDao extends JpaRepository<Asset, Integer> {
    /*@Query("SELECT e FROM Asset e ORDER BY e.id DESC")
    Page<Asset> findAll(Pageable of);*/

    @Query(value="SELECT new Asset(a.id,a.name) FROM Asset a")
    List<Asset> list();

    @Query("SELECT a FROM Asset a WHERE a.assetcode= :assetcode")
    Asset findByCode(@Param("assetcode")String assetcode);

    @Query("SELECT a FROM Asset a WHERE a.serialNumber= :serialNumber")
    Asset findBySerialNumber(@Param("serialNumber")String serialNumber);
}
