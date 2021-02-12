package com.example.accessingdatajpa;

import javax.persistence.*;

@Entity
public class BuddyInfo {

    @Id
    private final int id;

    private String name;

    private int age;

    public BuddyInfo(){
        this.id = -1;
        this.name = "";
        this.age = -1;
    }

    public BuddyInfo(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

}
