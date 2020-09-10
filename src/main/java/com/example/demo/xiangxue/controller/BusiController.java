package com.example.demo.xiangxue.controller;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.xiangxue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class BusiController {


    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "http://192.168.0.1:8080", maxAge = 3600)
    @ResponseBody
    @RequestMapping("/page")
    public Object selectPage(){

        Page page = new Page(1,10);          //1表示当前页，而10表示每页的显示显示的条目数
        page = userService.selectUserList(page);
        return page;
    }

    @RequestMapping("/user")
    @ResponseBody
    public String getAll(){
        return "你好";
    }
}
