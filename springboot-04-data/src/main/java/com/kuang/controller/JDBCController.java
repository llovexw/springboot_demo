package com.kuang.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author luorui
 * @company SCUT
 * @create 2022-04-04-22:21
 */
@RestController
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/userList")
    public List<Map<String,Object>> useList(){
        String sql = "select * from mybatis.user";
        List<Map<String, Object>> list_maps = jdbcTemplate.queryForList(sql);
        return list_maps;
    }

    @GetMapping("/addUser")
    public String addUSer(){
        String sql = "insert into mybatis.user(id,name,pwd) values(4,'小明','123456')";
        jdbcTemplate.update(sql);
        return "insert ok";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUSer(@PathVariable("id") int id){
        String sql = "update mybatis.user set name=?,pwd=? where id="+id;

        Object[] objects = new Object[2];
        objects[0]="小小明";
        objects[1]="zzzzzz";
        //方法重载，传入包装的objects对象，传入值进入预编译sql语句
        jdbcTemplate.update(sql,objects);
        return "update ok";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        String sql = "delete from mybatis.user where id=?";
        jdbcTemplate.update(sql,id);
        return "delete ok";
    }
}
