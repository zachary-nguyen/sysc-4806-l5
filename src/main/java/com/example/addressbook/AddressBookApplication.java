package com.example.addressbook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class AddressBookApplication {

    private static final Logger log = LoggerFactory.getLogger(AddressBookApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AddressBookApplication.class, args);
    }

    @Bean
    public CommandLineRunner initializeDB(AddressBookRepository addressBookRepository, BuddyInfoRepository buddyInfoRepository) {
        return (args) -> {
            log.info("Creating Buddies");
            // create and save buddies
            BuddyInfo mike = new BuddyInfo("Mike",12, "123 Street Ave");
            BuddyInfo bob = new BuddyInfo("Bob",22,"123 Street Ave");
            BuddyInfo peter = new BuddyInfo("Peter",32, "123 Street Ave");
            BuddyInfo sylvie = new BuddyInfo("Sylvie",10,"123 Street Ave");

            buddyInfoRepository.save(mike);
            buddyInfoRepository.save(bob);
            buddyInfoRepository.save(peter);
            buddyInfoRepository.save(sylvie);
            log.info("Buddies Saved");

            log.info("Address Book created");
            AddressBook addressBook = new AddressBook(1);

            // Add some buddies to address book
            addressBook.addBuddy(mike);
            addressBook.addBuddy(bob);
            addressBook.addBuddy(peter);
            addressBook.addBuddy(sylvie);
            // save some address book
            addressBookRepository.save(addressBook);
            log.info("Address Book saved");
        };
    }
}