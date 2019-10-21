package com.assetmanagement.dao;

import com.assetmanagement.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelDao extends JpaRepository<Model, Integer> {
}
