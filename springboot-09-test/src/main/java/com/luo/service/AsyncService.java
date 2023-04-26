package com.luo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author luorui
 * @company SCUT
 * @create 2022-05-04-16:28
 */
// Spring托管
@Service
public class AsyncService {


    // 告诉Spring这是个异步方法
    @Async
    public void hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("数据正在处理......");
    }
}
