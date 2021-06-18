package com.spc.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Demo implements ApplicationRunner {

    @Autowired
    PersonService service;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Person personByName = service.getPersonByName(1);
        System.out.println(personByName);
    }
}
