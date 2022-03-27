package com.demo1.pojo.noanotation;

/**
 * @author lihongjie
 * @date 2022/3/11
 */
public class Human {
    private Cat catPet;
    private Dog dog;
    private String name;
    private Integer id;

    public Human(){

    };

    public Human(Cat catPet, Dog dog, String name) {
        System.out.println("执行Human的构造方法进行自动注入......");
        this.catPet = catPet;
        this.dog = dog;
        this.name = name;
    }

    public Cat getCat() {
        return catPet;
    }

    public void setcatPet(Cat cat) {
        System.out.println("xml中bean标签上加autowire=byName/byType，走的是set方法自动注入");
        this.catPet = cat;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
