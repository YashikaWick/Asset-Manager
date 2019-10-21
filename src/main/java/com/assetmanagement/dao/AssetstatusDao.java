package com.assetmanagement.dao;

import com.assetmanagement.entity.Assetstatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssetstatusDao extends JpaRepository<Assetstatus, Integer> {

    @Query(value="SELECT new Assetstatus(e.id,e.name) FROM Assetstatus e")
    List<Assetstatus> list();
}
