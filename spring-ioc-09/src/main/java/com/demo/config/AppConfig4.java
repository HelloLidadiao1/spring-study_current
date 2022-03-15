package com.demo.config;

import com.demo.pojo2.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author lihongjie
 * @date 2022/3/15
 */
@Configuration
public class AppConfig4 {
    @Bean
    public Dog getDog(){
        return new Dog();
    }

    @Bean(name = "dog")
    public Dog getDog2(){
        Dog dog = new Dog();
        dog.setName("dog2");
        return dog;
    }
}
