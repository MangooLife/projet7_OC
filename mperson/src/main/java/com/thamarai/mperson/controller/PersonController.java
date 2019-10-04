package com.thamarai.mperson.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String getBooks(Model model) {
        return "Hello World";
    }
}
