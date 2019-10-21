package com.assetmanagement.controller;

import com.assetmanagement.dao.SupplierDao;
import com.assetmanagement.entity.Supplier;
import com.assetmanagement.util.ModuleList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SupplierController {

    @Autowired
    private SupplierDao dao;

    @RequestMapping(value = "/suppliers", params = {"page", "size"}, method = RequestMethod.GET, produces = "application/json")
    public Page<Supplier> findAll(@CookieValue(value="username") String username, @CookieValue(value="password") String password, @RequestParam("page") int page, @RequestParam("size") int size) {
        if(AuthProvider.isAuthorized(username,password, ModuleList.SUPPLIER,AuthProvider.SELECT)) {
            return dao.findAll(PageRequest.of(page, size));
        }
        return null;
    }

    @RequestMapping(value = "/suppliers/list", method = RequestMethod.GET, produces = "application/json")
    public List<Supplier> list(@CookieValue(value="username") String username, @CookieValue(value="password") String password) {
        if(AuthProvider.isUser(username,password)) {
            return dao.list();
        }
        return null;
    }


    @RequestMapping(value = "/suppliers", method = RequestMethod.POST)
    public String add(@CookieValue(value="username", required=false) String username, @CookieValue(value="password", required=false) String password, @Validated @RequestBody Supplier supplier) {

        if(AuthProvider.isAuthorized(username,password,ModuleList.SUPPLIER,AuthProvider.INSERT)) {
            Supplier supregno = dao.findByRegno(supplier.getRegno());
            if (supregno != null)
                return "Error-Validation : Reg number Exists";
            else
                try {
                    dao.save(supplier);
                    return "0";
                } catch (Exception e) {
                    return "Error-Saving : " + e.getMessage();
                }
        }
        return "Error-Saving : You have no Permission";

    }

    @RequestMapping(value = "/suppliers", method = RequestMethod.PUT)
    public String update(@CookieValue(value="username", required=false) String username, @CookieValue(value="password", required=false) String password,@Validated @RequestBody Supplier supplier) {

        if(AuthProvider.isAuthorized(username,password,ModuleList.SUPPLIER,AuthProvider.UPDATE)) {
            Supplier sup = dao.findByRegno(supplier.getRegno());
            if(sup==null || sup.getId()==supplier.getId()) {
                try {
                    dao.save(supplier);
                    return "0";
                }
                catch(Exception e) {
                    return "Error-Updating : "+e.getMessage();
                }
            }
            else {  return "Error-Updating : Reg Number Exists"; }
        }
        return "Error-Updating : You have no Permission";
    }

    @RequestMapping(value = "/suppliers", method = RequestMethod.DELETE)
    public String delete(@CookieValue(value="username", required=false) String username, @CookieValue(value="password", required=false) String password,@RequestBody Supplier supplier ) {
        if(AuthProvider.isAuthorized(username,password,ModuleList.SUPPLIER,AuthProvider.DELETE)) {
            try {
                dao.delete(dao.getOne(supplier.getId()));
                return "0";
            }
            catch(Exception e) {
                return "Error-Deleting : "+e.getMessage();
            }
        }
        return "Error-Deleting : You have no Permission";

    }



}
