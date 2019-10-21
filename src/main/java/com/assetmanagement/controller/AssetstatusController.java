package com.assetmanagement.controller;

import com.assetmanagement.dao.AssetstatusDao;
import com.assetmanagement.entity.Assetstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AssetstatusController {

    @Autowired
    private AssetstatusDao dao;

    @RequestMapping(value = "/assetstatuses/list", method = RequestMethod.GET, produces = "application/json")
    public List<Assetstatus> assetstatuses() {
        return dao.list();
    }
}
