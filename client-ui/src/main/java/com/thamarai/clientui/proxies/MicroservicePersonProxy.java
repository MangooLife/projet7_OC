package com.thamarai.clientui.proxies;

import com.thamarai.clientui.entity.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@FeignClient(contextId = "microservicePersonProxy", name = "zuul-server")
public interface MicroservicePersonProxy {
    /**
     * Get person page
     * @param personId
     * @return Person
     */
    @RequestMapping(value = {"/microservice-person/person/{personId}"}, method = RequestMethod.GET)
    Person getPersonPage(@PathVariable Long personId);

    /**
     * Post sign in
     * @param session
     * @param redirectAttributes
     * @param email
     * @param password
     * @return Person
     */
    @RequestMapping(value = {"/microservice-person/signin"}, method = RequestMethod.POST)
    Person signIn(
            HttpSession session,
            RedirectAttributes redirectAttributes,
            @RequestParam("email") String email,
            @RequestParam("password") String password
    );

    /**
     * Post create new person
     * @param session
     * @param redirectAttributes
     * @param firstname
     * @param lastname
     * @param email
     * @param password
     * @return Person
     */
    @RequestMapping(value = {"/microservice-person/newPerson"}, method = RequestMethod.POST)
    Person setPerson(
            HttpSession session,
            RedirectAttributes redirectAttributes,
            @RequestParam("firstname") String firstname,
            @RequestParam("lastname") String lastname,
            @RequestParam("email") String email,
            @RequestParam("password") String password
    );
}
