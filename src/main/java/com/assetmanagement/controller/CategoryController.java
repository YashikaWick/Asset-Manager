package com.assetmanagement.controller;

import com.assetmanagement.dao.CategoryDao;
import com.assetmanagement.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class CategoryController {

    @Autowired
    private CategoryDao dao;

    @RequestMapping(value = "/categories/list", method = RequestMethod.GET, produces = "application/json")
    public List<Category> categories() {
        return dao.list();
    }
}
