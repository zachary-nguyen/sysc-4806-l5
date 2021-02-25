package com.example.addressbook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;


@Controller
public class AddressBookController {

    private static final Logger log = LoggerFactory.getLogger(AddressBookApplication.class);

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
    @Transactional
    public String addressBookSubmit(@ModelAttribute BuddyForm buddyForm, Model model) {
        AddressBook addressBook = addressBookRepository.findById(1);

        // only create if valid fields
        if(!buddyForm.getAddress().isEmpty() && !buddyForm.getAge().isEmpty() && !buddyForm.getAddress().isEmpty()){
            BuddyInfo buddyInfo = new BuddyInfo(buddyForm.getName(), Integer.parseInt(buddyForm.getAge()),buddyForm.getAddress());
            addressBook.addBuddy(buddyInfo);
            this.addressBookRepository.save(addressBook);
            model.addAttribute("addressBook", addressBook);
        }
        return "addressbook";
    }

    @PostMapping("/addressbook-spa")
    @Transactional
    @ResponseBody
    public String addressBookSubmitSPA(@RequestBody BuddyForm buddyForm, Model model) {
        AddressBook addressBook = addressBookRepository.findById(1);

        // only create if valid fields
        if(!buddyForm.getAddress().isEmpty() && !buddyForm.getAge().isEmpty() && !buddyForm.getAddress().isEmpty()){
            BuddyInfo buddyInfo = new BuddyInfo(buddyForm.getName(), Integer.parseInt(buddyForm.getAge()),buddyForm.getAddress());
            addressBook.addBuddy(buddyInfo);
            addressBookRepository.save(addressBook);
        }

        return "addressbook-spa";
    }

    @GetMapping("/addressbook-spa")
    public String addressBookSpa() {
        return "addressbook-spa";
    }

}
