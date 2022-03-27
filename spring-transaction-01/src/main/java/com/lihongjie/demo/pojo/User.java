package com.lihongjie.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author lihongjie
 * @date 2022/3/24
 */
@Data
// 生成有参构造方法
@AllArgsConstructor
// 生成无参构造方法
@NoArgsConstructor
public class User {
    private Integer uid;
    private String uname;
    private String email;
}
