package com.example.addressbook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("com.example.addressbook")
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
            BuddyInfo mike = new BuddyInfo(1,"Mike",12);
            BuddyInfo bob = new BuddyInfo(2,"Bob",22);
            BuddyInfo peter = new BuddyInfo(3,"Peter",32);
            BuddyInfo sylvie = new BuddyInfo(4,"Sylvie",42);

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