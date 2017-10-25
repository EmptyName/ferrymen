package com.fm;


import org.apache.log4j.PropertyConfigurator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by aiyi on 2017/5/2.
 */

@EnableAutoConfiguration
@ComponentScan
@Configuration
@RestController
@EnableTransactionManagement
@MapperScan("com.fm.mapper")
public class Application {


    static {
        try{
            //初始化log4j
            String log4jPath = Application.class.getClassLoader().getResource("").getPath()+"/log4j.properties";
            System.out.println("初始化Log4j。。。。");
            System.out.println("path is "+ log4jPath);
            PropertyConfigurator.configure(log4jPath);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }





}
