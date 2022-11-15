package com.lening.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {

    //登录
    @RequestMapping("/index")
    private String toLogin(){
        return "index";
    }

    @RequestMapping("/managerList")
    public String goodsList(){
        return "manager_list";
    }

}
