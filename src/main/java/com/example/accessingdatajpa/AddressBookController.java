package com.example.accessingdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AddressBookController {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    @Autowired
    private AddressBookRepository addressBookRepository;

    @GetMapping("/addressbook")
    public String addressBook(Model model) {
        AddressBook addressBook = addressBookRepository.findById(1);
        log.info(String.valueOf(addressBook.getBuddies().get(1).getAge()));
        model.addAttribute("addressBook", addressBook);
        return "addressbook";
    }

    @PostMapping("/addressbook")
    public String addressBookSubmit(@ModelAttribute AddressBook addressBook, Model model) {
        model.addAttribute("addressBook", addressBook);
        return "addressbook";
    }
}
