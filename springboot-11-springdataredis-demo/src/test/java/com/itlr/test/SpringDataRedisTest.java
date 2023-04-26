package com.itlr.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author luorui
 * @company SCUT
 * @create 2022-05-24-17:38
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringDataRedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    // 不需要配置类直接强转为StringRedisTemplate对象亦可
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testString(){
        redisTemplate.opsForValue().set("test01","beijing");
    }
}
