package com.kunag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author luorui
 * @company SCUT
 * @create 2022-04-01-16:12
 */
@Controller
//先设置一个大根目录
@RequestMapping("/hello")
public class HelloController {
    //在设置小目录
    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello,World";
    }
}
