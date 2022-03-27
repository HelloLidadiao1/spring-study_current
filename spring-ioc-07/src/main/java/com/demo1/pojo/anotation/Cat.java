package com.demo1.pojo.anotation;

/**
 * @author lihongjie
 * @date 2022/3/11
 */
public class Cat {
    private String catName;

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public void shout(){
        System.out.println("猫在叫，瞄~");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "catName='" + catName + '\'' +
                '}';
    }
}
