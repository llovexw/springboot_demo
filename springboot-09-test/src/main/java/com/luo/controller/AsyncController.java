package com.luo.controller;

import com.luo.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luorui
 * @company SCUT
 * @create 2022-05-04-16:29
 */

@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    @RequestMapping("/hello")
    public String hello(){
        asyncService.hello(); // 停止三秒,转圈,极度影响用户体验
        return "OK";
    }
}
