package com.assetmanagement.controller;

import com.assetmanagement.dao.SubcategoryDao;
import com.assetmanagement.entity.Category;
import com.assetmanagement.entity.Subcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class SubcategoryController {
    @Autowired
    private SubcategoryDao dao;

    /*@RequestMapping(value = "/subcategories/list", method = RequestMethod.GET, produces = "application/json")
    public List<Subcategory> list(@CookieValue(value="username") String username, @CookieValue(value="password") String password) {
        if(AuthProvider.isUser(username,password)) {
            return dao.list();
        }
        return null;
    }*/

    @RequestMapping(value = "/subcategories/listbycategory",params ="categoryId",method = RequestMethod.GET, produces = "application/json")
    public List<Subcategory> list(@RequestParam("categoryId") Integer categoryId){
        return dao.listByCategory(categoryId);
    }
}
