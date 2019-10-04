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

    @RequestMapping(value = {"/connect"}, method = RequestMethod.GET)
    public String getConnectPage(
            Model model,
            HttpSession session
    ) {
        return "Page de connexion";
    }

    @RequestMapping(value = {"/disconnect"}, method = RequestMethod.GET)
    public String getDisonnectPage(
            Model model,
            HttpSession session
    ) {
        return "Page de deconnexion";
    }

    @RequestMapping(value = {"/subscriptionPage"}, method = RequestMethod.GET)
    public String getSubscriptionPage(
            Model model,
            HttpSession session
    ) {
        return "Page de souscription";
    }

    @RequestMapping(value = {"/person/{personId}"}, method = RequestMethod.GET)
    public String getPersonPage(
            Model model,
            HttpSession session,
            @PathVariable Long personId
    ) {
        Person person = null;
        try{
            person = personService.getPerson(personId).orElseThrow( () ->
                    new PersonNotFoundException("There is not Person with this id "+personId)
            );
        } catch (Exception e) {
            LOGGER.error("There is not Person with this id "+personId+" "+e);
        }
        return "Page de connexion";
    }

    @RequestMapping(value = {"/signin"}, method = RequestMethod.POST)
    public String signIn(
            HttpSession session,
            RedirectAttributes redirectAttributes,
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ) {
        if(personService.passwordOk(email, password)) {
            Person person;
            try {
                person = personService.authentificateUser(email).orElseThrow(() ->
                            new PersonNotFoundException("This person's mail doesn't exist "+email)
                        );
            } catch(Exception e) {
                LOGGER.error("This person's mail doesn't exist "+email+" "+e);
                redirectAttributes.addFlashAttribute(
                        "message", "L'username ou le mot de passe est mauvais");
                return "Page connexion : problème (mdp ou email erroné)";
            }
            session.setAttribute("firstname", person.getFirstname());
            session.setAttribute("lastname", person.getLastname());
            session.setAttribute("isAdmin", person.getIsAdmin());
            //return person(session, model, redirectAttributes);
            return "Page person : Bien connecté";
        } else {
            redirectAttributes.addFlashAttribute(
                    "message", "L'username ou le mot de passe est mauvais");
            // return new ModelAndView("redirect:/connexion");
            return "Page connexion : problème (mdp ou email erroné)";
        }
    }

    @RequestMapping(value = {"/newPerson"}, method = RequestMethod.POST)
    public String setPerson(
            HttpSession session,
            RedirectAttributes redirectAttributes,
            @RequestParam("firstname") String firstname,
            @RequestParam("lastname") String lastname,
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ) {
        if(password.length() < 8) {
            redirectAttributes.addFlashAttribute(
                    "message", "Le mot de passe est trop petit");
            //return new ModelAndView("redirect:/subscribe");
            return "Mot de passe trop petit";

        } else {
            Person person = new Person();
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
        return "Connexion réussite";
    }
}
