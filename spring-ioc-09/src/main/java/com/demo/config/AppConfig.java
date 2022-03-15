package com.demo.config;

import com.demo.pojo.Cat;
import com.demo.pojo2.Dog;
import com.demo.pojo.Human;
import com.demo.pojo.Snake;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author lihongjie
 * @date 2022/3/15
 */
@Configuration
@Import(value = AppConfig4.class)
@ComponentScan(basePackages = "com.demo.pojo")
public class AppConfig {

    @Bean
    public Cat getCat(){
       return new Cat();
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Human getHuman1(Cat cat, Dog dog){
        return new Human(getCat(), dog);
    }

    @Bean(name = "human")
    public Human getHuman2(Cat cat, Dog dog, Snake snake){
        return new Human(cat, dog, snake);
    }
}
