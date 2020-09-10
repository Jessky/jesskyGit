package com.example.demo.xiangxue.core;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.xiangxue.entity.User;
import javafx.scene.control.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("selectUserList")
    IPage<User> selectUserList(Page page);

    @Select("queryTotal")
    List<User> queryTotal();


}

