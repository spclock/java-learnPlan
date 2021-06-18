package com.spc.mybatis;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class StudentProvider {

    public String selectBySno() {
        Map<String,String> map=new HashMap<String, String>(){{
            put("hello","world");
            put("linux","yyds");
        }};
        return new SQL() {{
            SELECT("*");
            FROM("student");
            WHERE("sno=#{sno}");
        }}.toString();
    }

//    public String selectStudent(Student student) {
//        return new SQL() {
//            {
//                SELECT("*");
//                FROM("student");
//                WHERE("sno=#{sno}");
//                if (StringUtils.hasLength(student.getName())) {
//                    // WHERE("sname like %${name}%"); //直接注入 无法防注入
//                    // WHERE("sname like \"%\"#{name}\"%\""); //"%" 需要使用"" sql语句不明确
//                    WHERE("sname like concat('%',#{name},'%')"); //使用sql函数拼接 相对推荐
//                }
//            }
//        };
//    }
}
