package com.learn.mybatis.druid;

import com.learn.mybatis.druid.mysqlDao.PersonMapper;
import com.learn.mybatis.druid.mysqlTestDao.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class);

    }
}
