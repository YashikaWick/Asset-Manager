package com.assetmanagement.dao;


import com.assetmanagement.entity.Sessionlog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionDao extends JpaRepository<Sessionlog, Integer>
{

}