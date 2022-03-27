package com.lihongjie.demo.mapper;

import com.lihongjie.demo.pojo.Student;

import java.util.List;

/**
 * @author lihongjie
 * @date 2022/3/21
 */
public interface StuMapper {
    //批量插入学生
    public Integer insertStus(List<Student> stus);
}