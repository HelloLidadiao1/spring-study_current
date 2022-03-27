package com.demo1.pojo;

import com.demo1.pojo2.Dog;

import java.util.Optional;

/**
 * @author lihongjie
 * @date 2022/3/15
 */
public class Human {
    private Cat cat;
    private Dog dog;
    private Snake snake;

    private String name;

    public Human(Cat cat, Dog dog, Snake snake) {
        System.out.println("进入Human构造器方法....");
        this.cat = cat;
        this.dog = dog;
        this.snake = snake;
    }

    public void init(){
        System.out.println("进入Human初始化方法，造人计划开始.....");
    }

    public void destroy(){
        System.out.println("进入Human销毁前方法，造人计划结束.....");
    }

    public Human(){

    }

    public Human(Cat cat, Dog dog) {
        this.cat = cat;
        this.dog = dog;
    }

    public void playPet(){
        System.out.println(name + " 开始玩宠物.....");
        if(Optional.ofNullable(cat).isPresent()){
           cat.shout();
        }

        if(Optional.ofNullable(dog).isPresent()){
            dog.shout();
        }

        if(Optional.ofNullable(snake).isPresent()){
            snake.shout();
        }
        System.out.println(name + " 结束玩宠物.....");
    }
}
