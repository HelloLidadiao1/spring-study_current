package com.lihongjie.demo.pojo;

import lombok.Data;

/**
 * @author lihongjie
 * @date 2022/3/22
 */
@Data
public class Student {
    private Integer sid;
    private String sname;
    private Integer tid;

    public Student(Integer sid, String sname, Integer tid) {
        this.sid = sid;
        this.sname = sname;
        this.tid = tid;
    }

    public Student(){

    }
}
