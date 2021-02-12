package com.example.addressbook;

import javax.persistence.*;

@Entity
public class BuddyInfo {

    @Id
    private final int id;

    private String name;

    private int age;

    private String address;

    public BuddyInfo(){
        this.id = -1;
        this.name = "";
        this.age = -1;
        this.address = "";
    }

    public BuddyInfo(int id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
