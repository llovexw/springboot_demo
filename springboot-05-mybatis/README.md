# 工程简介

# 延伸阅读

需要导入springboot-mybatis的包
```xml
<dependencies>
        <!-- https://mvnrepository.com/artifact/org.mybatis.spring.boot/mybatis-spring-boot-starter -->
        <!--mybatis配置,整合mybatis-->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.2.2</version>
        </dependency>

        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jdbc</artifactId>
        </dependency>
</dependencies>
```

//在application.properties整合mybatis 
```properties
mybatis.type-aliases-package=com.kunag.pojo
mybatis.mapper-locations=classpath:mybatis/mapper/*.xml
```
