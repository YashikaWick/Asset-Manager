package com.assetmanagement.dao;

import com.assetmanagement.entity.Asset;
import com.assetmanagement.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BranchDao extends JpaRepository<Branch, Integer> {

    @Query(value="SELECT new Branch (e.id,e.name) FROM Branch e")
    List<Branch> list();
}
