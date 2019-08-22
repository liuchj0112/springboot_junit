package com.springboot.junit.pojo;

/**
 * @projectName springboot_junit_demo
 * @Description TODO
 * @Author liuchj
 * @Date 2019/08/22 10:18
 * @Version 1.0
 **/

public class User  {
    private  Integer id;
    private String username;
    private Integer age;
    private Integer gender;

    public User(Integer id, String username, Integer age, Integer gender) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
