package com.example.demo.xiangxue.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.xiangxue.core.UserMapper;
import com.example.demo.xiangxue.entity.User;
import com.example.demo.xiangxue.service.UserService;
import javafx.scene.control.Pagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public Page<User> selectUserList(Page<User> page) {
        logger.info("-============="+page.toString());
        IPage<User> list = baseMapper.selectUserList(page);
        logger.info("-============="+list);
        page.setRecords(list.getRecords());
        return page;
    }
}
