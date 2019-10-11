package com.thamarai.clientui.controller;

import com.thamarai.clientui.entity.Category;
import com.thamarai.clientui.proxies.MicroserviceBookProxy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ClientUIController {

    private static final Logger LOGGER = LogManager.getLogger(ClientUIController.class);

    @Autowired
    MicroserviceBookProxy microserviceBookProxy;

    /**
     * Get Home page
     * @param model
     * @return Home page
     */
    @RequestMapping("/")
    public String home(Model model) {
        LOGGER.info("get home page");
        List<Category> categories = microserviceBookProxy.getCategories();
        model.addAttribute("categories", categories);
        return "home";
    }
}
