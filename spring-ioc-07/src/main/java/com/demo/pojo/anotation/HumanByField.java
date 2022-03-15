package com.demo.pojo.anotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.lang.Nullable;

/**
 * @author lihongjie
 * @date 2022/3/11
 */
public class HumanByField {
    @Autowired(required = false)
    //@Qualifier("catPet")
    private Cat catPet2;

    @Autowired(required = false)
    private Dog dog;

    @Autowired
    @Nullable
    private Frog frog;
    private String name;
    private Integer id;

    public Cat getCat() {
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
