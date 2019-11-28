package com.thamarai.clientui.controller;

import com.thamarai.clientui.entity.Loan;
import com.thamarai.clientui.entity.Person;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

    @Autowired
    private MicroservicePersonProxy microservicePersonProxy;

    @Autowired
    private MicroserviceLoanProxy microserviceLoanProxy;

    /**
     * USER MANAGEMENT
     */

    /**
     * Post create new person
     * @param session
     * @param firstname
     * @param lastname
     * @param email
     * @param password
     * @return Person
     */
    @RequestMapping(value = {"/newPerson"}, method = RequestMethod.POST)
    public ModelAndView setPerson(
            HttpSession session,
            RedirectAttributes redirectAttributes,
            @RequestParam("firstname") String firstname,
            @RequestParam("lastname") String lastname,
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ) {
        if(password.length() < 8) {
            LOGGER.info("message", "Le mot de passe est trop petit");
            redirectAttributes.addFlashAttribute(
                    "messageFail", "Le mot de passe est trop petit");
            return new ModelAndView("redirect:/");
        } else {
            microservicePersonProxy.setPerson(firstname, lastname, email, password);redirectAttributes.addFlashAttribute(
                    "messageSuccess", "Inscription finalisée avec succès. Veuillez vous connecter :) ");
        }
        return new ModelAndView("redirect:/");
    }

    /**
     * Post sign in
     * @param session
     * @param email
     * @param password
     * @return Person
     */
    @RequestMapping(value = {"/signin"}, method = RequestMethod.POST)
    public String signIn(
            HttpSession session,
            Model model,
            RedirectAttributes redirectAttributes,
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ) {
        Person person = microservicePersonProxy.signIn(email, password);

        if(person == null){
            redirectAttributes.addFlashAttribute(
                    "messageFail", "L'username ou le mot de passe est mauvais");
            return "redirect:/";
        }

        model.addAttribute("person", person);
        session.setAttribute("id", person.getId());
        session.setAttribute("firstname", person.getFirstname());
        session.setAttribute("lastname", person.getLastname());

        return "redirect:/person/"+session.getAttribute("id");
    }

    /**
     * Post sign out
     * @return String
     */
    @RequestMapping(value = {"/signout"}, method = RequestMethod.GET)
    public String signOut(
            Model model,
            RedirectAttributes redirectAttributes,
            HttpSession session,
            String template
    ) {
        LOGGER.debug("Deconnexion page OK");
        session.removeAttribute("firstname");
        session.removeAttribute("lastname");
        session.removeAttribute("id");
        LOGGER.debug("message", "Vous êtes déconnecté");
        redirectAttributes.addFlashAttribute(
                "messageSuccess", "Déconnexion avec succès :)");

        return "redirect:/";
    }

    @RequestMapping("/person/{id}")
    public ModelAndView person(
            Model model,
            HttpSession session,
            @PathVariable("id") final Long id

    ) {
        LOGGER.info("get homepage");

        Person person = microservicePersonProxy.getPersonPage(id);
        model.addAttribute("person", person);

        List<Loan> loans = microserviceLoanProxy.getLoansById(id);
        model.addAttribute("loans", loans);

        return new ModelAndView ("connectedPage");
    }

    @RequestMapping("/extendLoan/{loanId}")
    public ModelAndView person(
            HttpSession session,
            RedirectAttributes redirectAttributes,
            @PathVariable("loanId") final Long loanId
    ) {
        LOGGER.info("get homepage");

        Loan loan = microserviceLoanProxy.extendLoan(loanId);

        redirectAttributes.addFlashAttribute(
                "messageSuccess", "Emprunt prolongé avec succès :)");

        return new ModelAndView("redirect:/person/"+session.getAttribute("id"));
    }
}
