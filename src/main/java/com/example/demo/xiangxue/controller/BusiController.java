package com.example.demo.xiangxue.controller;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.xiangxue.service.UserService;
import com.example.demo.xiangxue.service.impl.UserServiceImpl;
import com.example.demo.xiangxue.util.JedisCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class BusiController {

    private static Logger logger = LoggerFactory.getLogger(BusiController.class);
    @Autowired
    private UserService userService;

    @Autowired
    JedisCache jedisCache;


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
        logger.info("进入user方法");
        String s = jedisCache.setString("shanggq测试","shangg");
        return s;
    }
}
