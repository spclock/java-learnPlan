package com.spc.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();


    public Person getPersonByName(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            PersonDao personDao = session.getMapper(PersonDao.class);
            return personDao.getPersonById(id);
        } catch (SqlSessionException e) {
            throw new RuntimeException(e);
        }
    }
}
