package com.learn.mybatis.druid;

import com.learn.mybatis.druid.mysqlDao.PersonMapper;
import com.learn.mybatis.druid.mysqlTestDao.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    PersonMapper personMapper;

    @Autowired
    StudentMapper studentMapper;

    @GetMapping("/get")
    public void get(){
        System.out.println(personMapper.findAll());

        System.out.println(studentMapper.findAll());
    }
}
