package com.kuang.controller;

import com.kuang.mapper.UserMapper;
import com.kuang.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author luorui
 * @company SCUT
 * @create 2022-04-06-11:40
 */
@RestController
public class UseController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/queryUserList")
    public List<User> queryUserList(){
        List<User> userList = userMapper.queryUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        return userList;
    }

    @GetMapping("/addUser")
    @Transactional(rollbackFor = Exception.class)
    public String addUser(){
        try {
            int i = userMapper.addUser(new User(4,"小张","456123"));
            if(i!=1){throw new Exception("新增失败");}
        } catch (Exception e) {
            System.out.println("有异常");
            return "add false";
        }
        return "add ok";
    }

    @GetMapping("/updateUser")
    public String updateUser(){
        userMapper.updateUser(new User(4,"小张","456789"));
        return "update ok";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(){
        userMapper.deleteUser(4);
        return "delete ok";
    }
}
