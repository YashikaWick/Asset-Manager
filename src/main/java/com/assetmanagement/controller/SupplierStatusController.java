package com.assetmanagement.controller;

import com.assetmanagement.dao.SupplierStatusDao;
import com.assetmanagement.entity.Supplierstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SupplierStatusController {

    @Autowired
    private SupplierStatusDao dao;

    @RequestMapping(value = "/supplierstatuses/list", method = RequestMethod.GET, produces = "application/json")
    public List<Supplierstatus> supplierstatuses() {
        return dao.list();
    }
}
