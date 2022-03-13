package com.demo.pojo;

/**
 * @author lihongjie
 * @date 2022/3/5
 */
public class Hobby {
    private String hobbyName;
    private String hobbyId;

    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }

    public String getHobbyId() {
        return hobbyId;
    }

    public void setHobbyId(String hobbyId) {
        this.hobbyId = hobbyId;
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "hobbyName='" + hobbyName + '\'' +
                ", hobbyId='" + hobbyId + '\'' +
                '}';
    }
}
