package com.learn.mybatis.druid.mysqlDao;

import com.learn.mybatis.druid.entity.Person;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper
public interface PersonMapper {

    List<Person> findAll();
}
