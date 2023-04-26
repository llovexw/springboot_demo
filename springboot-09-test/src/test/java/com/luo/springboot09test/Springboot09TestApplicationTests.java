package com.luo.springboot09test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.text.SimpleDateFormat;

@SpringBootTest
class Springboot09TestApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    /**
     * 简单发送邮件功能
     * @Author luorui~
     */
    void contextLoads() {

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setSubject("你好呀");
        mailMessage.setText("再见!!!");

        mailMessage.setTo("2542590210@qq.com");
        mailMessage.setFrom("2542590210@qq.com");
        mailSender.send(mailMessage);
    }

}
