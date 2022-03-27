package com.lihongjie.demo.exception;

/**
 * 自定义异常类型
 * @author lihongjie
 * @date 2022/3/25
 */
public class MyException extends Exception{
    public MyException(String message) {
        super(message);
    }

    public MyException() {
    }
}
