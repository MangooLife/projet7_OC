package com.thamarai.clientui.controller;

import com.thamarai.clientui.entity.*;
import com.thamarai.clientui.proxies.MicroserviceBookProxy;
import com.thamarai.clientui.proxies.MicroserviceLoanProxy;
import com.thamarai.clientui.proxies.MicroservicePersonProxy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ClientUIController {

    private static final Logger LOGGER = LogManager.getLogger(ClientUIController.class);

    @Autowired
    private MicroserviceBookProxy microserviceBookProxy;

    @Autowired
    private MicroservicePersonProxy microservicePersonProxy;

    @Autowired
    private MicroserviceLoanProxy microserviceLoanProxy;

    /**
     * HOME PART
     */

    /**
     * Get Home page
     * @param model
     * @return Home page
     */
    @RequestMapping("/")
    public String home(Model model) {
        LOGGER.info("get homepage");

        List<Book> books = microserviceBookProxy.getBooks();
        model.addAttribute("books", books);

        List<Category> categories = microserviceBookProxy.getCategories();
        model.addAttribute("categories", categories);

        return "home";
    }

    /**
     * BOOK PART
     */

    @RequestMapping(value = {"/book/{id}"}, method = RequestMethod.GET)
    public String site(@PathVariable("id") final Long id, Model model) {
        Book book = microserviceBookProxy.getBook(id);
        model.addAttribute("book", book);

        List<Copy> copies = microserviceBookProxy.getCopiesById(id);
        model.addAttribute("copies", copies);
        return "book";
    }

}
