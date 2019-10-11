package com.thamarai.mperson.controller;

import com.thamarai.mperson.entity.Person;
import com.thamarai.mperson.exception.PersonNotFoundException;
import com.thamarai.mperson.service.PersonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@RestController
public class PersonController {

    private static final Logger LOGGER = LogManager.getLogger(PersonController.class);

    @Autowired
    PersonService personService;

    /**
     * Get person page
     * @param personId
     * @return Person
     */
    @RequestMapping(value = {"/person/{personId}"}, method = RequestMethod.GET)
    public Person getPersonPage(@PathVariable Long personId) {
        Person person = null;
        try{
            person = personService.getPerson(personId).orElseThrow( () ->
                    new PersonNotFoundException("There is not Person with this id "+personId)
            );
        } catch (Exception e) {
            LOGGER.error("There is not Person with this id "+personId+" "+e);
        }
        return person;
    }

    /**
     * Post sign in
     * @param session
     * @param redirectAttributes
     * @param email
     * @param password
     * @return Person
     */
    @RequestMapping(value = {"/signin"}, method = RequestMethod.POST)
    public Person signIn(
            HttpSession session,
            RedirectAttributes redirectAttributes,
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ) {
        Person person = null;
        if(personService.passwordOk(email, password)) {
            try {
                person = personService.authentificateUser(email).orElseThrow(() ->
                            new PersonNotFoundException("This person's mail doesn't exist "+email)
                        );
            } catch(Exception e) {
                LOGGER.error("This person's mail doesn't exist "+email+" "+e);
                redirectAttributes.addFlashAttribute(
                        "message", "L'username ou le mot de passe est mauvais");
            }
            session.setAttribute("firstname", person.getFirstname());
            session.setAttribute("lastname", person.getLastname());
            session.setAttribute("isAdmin", person.getIsAdmin());
            return person;
        } else {
            redirectAttributes.addFlashAttribute(
                    "message", "L'username ou le mot de passe est mauvais");
            return person;
        }
    }

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
    @RequestMapping(value = {"/newPerson"}, method = RequestMethod.POST)
    public Person setPerson(
            HttpSession session,
            RedirectAttributes redirectAttributes,
            @RequestParam("firstname") String firstname,
            @RequestParam("lastname") String lastname,
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ) {
        Person person = new Person();
        if(password.length() < 8) {
            redirectAttributes.addFlashAttribute(
                    "message", "Le mot de passe est trop petit");
            return person;

        } else {
            person.setFirstname(firstname);
            person.setLastname(lastname);
            person.setPassword(password);
            person.setEmail(email);
            person.setIsAdmin(0);
            personService.addPerson(person);
            session.setAttribute("firstname", person.getFirstname());
            session.setAttribute("lastname", person.getLastname());
            session.setAttribute("member", person.getIsAdmin());
            redirectAttributes.addFlashAttribute(
                    "messageSuccess", "Inscription réussite, bravo =)");
            //return person(session, model, redirectAttributes);
        }
        return person;
    }
}
