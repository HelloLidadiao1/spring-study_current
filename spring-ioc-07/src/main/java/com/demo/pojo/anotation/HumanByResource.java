package com.demo.pojo.anotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;

import javax.annotation.Resource;

/**
 * @author lihongjie
 * @date 2022/3/11
 */
public class HumanByResource {
    @Resource(name = "catPet2")
    private Cat catPet3;

    @Resource
    private Cat catPet2;

    @Resource
    private Dog dog;

    @Autowired
    private String name;
    private Integer id;

    public Cat getCatPet3() {
        return catPet3;
    }

    public Cat getCatPet2() {
        return catPet2;
    }

    public Dog getDog() {
        return dog;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

}
