package com.itlr.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @author luorui
 * @company SCUT
 * @create 2022-05-24-17:19
 * 使用Jedis操作Redis中的数据
 */
public class JedisTest {

    @Test
    public void testRedis(){
        // 1.获取连接
        Jedis jedis = new Jedis("localhost",6379);
        // 2.执行具体的操作
        jedis.set("username","xiaoming");
        String value = jedis.get("username");
        System.out.println(value);
        System.out.println(jedis.dbSize());

        jedis.del("username");
        System.out.println(jedis.dbSize());

        jedis.hset("myhash","addr","bj");
        System.out.println(jedis.hget("myhash","addr"));

        System.out.println("********************");
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }
        // 3.关闭连接
        jedis.close();
    }
}
