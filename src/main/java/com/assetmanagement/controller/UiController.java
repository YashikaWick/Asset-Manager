package com.assetmanagement.controller;


import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/ui")
public class UiController {



    @RequestMapping("/config")
    public ModelAndView config(){
        ModelAndView model = new ModelAndView();
        model.setViewName("config.html");
        return model;
    }

    @RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView model = new ModelAndView();
        model.setViewName("login.html");
        return model;
    }

    @RequestMapping("/loginnew")
    public ModelAndView loginnew(){
        ModelAndView model = new ModelAndView();
        model.setViewName("loginnew.html");
        return model;
    }


    @RequestMapping("/mainwindow")
    public ModelAndView mainwindow(@CookieValue(value="username") String username, @CookieValue(value="password") String password){
        return getModelView("mainwindow.html",username,password);
    }

    @RequestMapping("/sidebar")
    public  ModelAndView sidebar(@CookieValue(value = "username") String username, @CookieValue(value = "password") String password){
        return getModelView("sidebar.html",username,password);
    }



    @RequestMapping("/home")
    public ModelAndView home(@CookieValue(value="username") String username, @CookieValue(value="password") String password){
        return getModelView("home.html",username,password);
    }


    @RequestMapping("/employee")
    public ModelAndView employee(@CookieValue(value="username") String username, @CookieValue(value="password") String password){
        return getModelView("employee.html",username,password);
    }


    @RequestMapping("/user")
    public ModelAndView user(@CookieValue(value="username") String username, @CookieValue(value="password") String password){
        return getModelView("user.html",username,password);
    }

    @RequestMapping("/previlage")
    public ModelAndView previlage(@CookieValue(value="username") String username, @CookieValue(value="password") String password){
        return getModelView("previlage.html",username,password);

    }


    @RequestMapping("/changepassword")
    public ModelAndView changepassword(@CookieValue(value="username") String username, @CookieValue(value="password") String password){
        return getModelView("changepassword.html",username,password);
    }


    @RequestMapping("/designation")
    public ModelAndView designation(@CookieValue(value="username") String username, @CookieValue(value="password") String password){
        return getModelView("designation.html",username,password);
    }

    @RequestMapping("/asset")
    public ModelAndView asset(@CookieValue(value="username") String username, @CookieValue(value="password") String password){
        return getModelView("asset.html",username,password);
    }

    @RequestMapping("/supplier")
    public ModelAndView supplier(@CookieValue(value="username") String username, @CookieValue(value="password") String password){
        return getModelView("supplier.html",username,password);
    }

    @RequestMapping("/checkin")
    public ModelAndView checkin(@CookieValue(value="username") String username, @CookieValue(value="password") String password){
        return getModelView("checkin.html",username,password);
    }

    @RequestMapping("/checkout")
    public ModelAndView checkout(@CookieValue(value="username") String username, @CookieValue(value="password") String password){
        return getModelView("checkout.html",username,password);
    }

    @RequestMapping("/reserve")
    public ModelAndView reserve(@CookieValue(value="username") String username, @CookieValue(value="password") String password){
        return getModelView("reserve.html",username,password);
    }

    @RequestMapping("/branch")
    public ModelAndView branch(@CookieValue(value="username") String username, @CookieValue(value="password") String password){
        return getModelView("branch.html",username,password);
    }

    @RequestMapping("/location")
    public ModelAndView location(@CookieValue(value="username") String username, @CookieValue(value="password") String password){
        return getModelView("location.html",username,password);
    }

    @RequestMapping("/category")
    public ModelAndView category(@CookieValue(value="username") String username, @CookieValue(value="password") String password){
        return getModelView("category.html",username,password);
    }

    @RequestMapping("/subcategory")
    public ModelAndView subcategory(@CookieValue(value="username") String username, @CookieValue(value="password") String password){
        return getModelView("subcategory.html",username,password);
    }

    @RequestMapping("/brand")
    public ModelAndView brand(@CookieValue(value="username") String username, @CookieValue(value="password") String password){
        return getModelView("brand.html",username,password);
    }

    @RequestMapping("/model")
    public ModelAndView model(@CookieValue(value="username") String username, @CookieValue(value="password") String password){
        return getModelView("model.html",username,password);
    }

    @RequestMapping("/dispose")
    public ModelAndView dispose(@CookieValue(value="username") String username, @CookieValue(value="password") String password){
        return getModelView("dispose.html",username,password);
    }





    public ModelAndView getModelView(String page,String username, String password){

        ModelAndView model = new ModelAndView();

        if(AuthProvider.isUser(username,password)) {

            model.setViewName(page);
        }
        else {
            model.setViewName("noprivilage.html");

        }
        return model;

    }



}