package com.demo1.config;

import com.demo1.pojo2.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
