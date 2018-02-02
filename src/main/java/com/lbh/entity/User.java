package com.lbh.entity;

/**
 * Created by Advancer on 2018/1/17 15:46.
 * auth: lbh
 */
public class User {

    private Integer id;
    private String name;
    private String age;
    private double money;

    public User() {
    }

    public User(String name, String age, double money) {
        this.name = name;
        this.age = age;
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", money=" + money +
                '}';
    }
}
