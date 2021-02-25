package com.example.addressbook;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BuddyForm {

    @JsonProperty("name")
    private String name;
    @JsonProperty("age")
    private String age;
    @JsonProperty("address")
    private String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
