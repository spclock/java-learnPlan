package com.learn.mybatis.druid.mysqlTestDao;

import com.learn.mybatis.druid.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper
public interface StudentMapper {

    List<Student> findAll();
}
