package com.assetmanagement.controller;

import com.assetmanagement.dao.BranchDao;
import com.assetmanagement.entity.Asset;
import com.assetmanagement.entity.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class BranchController {

    @Autowired
    private BranchDao dao;

    /*@RequestMapping(value = "/branches/list", method = RequestMethod.GET, produces = "application/json")
    public List<Branch> list(@CookieValue(value="username") String username, @CookieValue(value="password") String password) {
        if(AuthProvider.isUser(username,password)) {
            return dao.list();
        }
        return null;
    }*/

    @RequestMapping(value = "/branches/list", method = RequestMethod.GET, produces = "application/json")
    public List<Branch> branches() {
        return dao.list();
    }
}
