package com.example.addressbook;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook{

    @Id
    private final int id;

    @OneToMany(cascade = CascadeType.MERGE)
    private List<BuddyInfo> buddies;

    // Constructor
    public AddressBook() {
        this.id = -1;
        this.buddies = new ArrayList<>();
    }

    public AddressBook(int id) {
        this.id = id;
        this.buddies = new ArrayList<>();
    }

    public void addBuddy(BuddyInfo buddyInfo){
        this.buddies.add(buddyInfo);
    }

    public List<BuddyInfo> getBuddies() {
        return buddies;
    }

    public void setBuddies(ArrayList<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    public int getId() {
        return id;
    }
}
