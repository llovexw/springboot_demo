package com.luo.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author luorui
 * @company SCUT
 * @create 2022-05-04-16:55
 */

@Service
public class ScheduledService {
    // 在一个特定的时间执行这个方法~ Timer

    //cron表达式
    // 秒 分 时 日 月 周几(0~7)
    //@Scheduled(cron = "0 * * * * 0-7")
    // 间隔两秒执行,可在网上查询到cron
    @Scheduled(cron = "0/2 * * * * ? ")
    public void hello1(){
        System.out.println("hello,你被执行了");
    }
}
