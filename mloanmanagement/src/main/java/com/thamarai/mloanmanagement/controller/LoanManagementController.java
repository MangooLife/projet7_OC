package com.thamarai.mloanmanagement.controller;

import com.thamarai.mloanmanagement.entity.Copy;
import com.thamarai.mloanmanagement.entity.Loan;
import com.thamarai.mloanmanagement.entity.Person;
import com.thamarai.mloanmanagement.exception.LoanNotFoundException;
import com.thamarai.mloanmanagement.service.CopyService;
import com.thamarai.mloanmanagement.service.LoanService;
import com.thamarai.mloanmanagement.service.PersonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@RestController
public class LoanManagementController {

    private static final Logger LOGGER = LogManager.getLogger(LoanManagementController.class);

    @Autowired
    LoanService loanService;

    @Autowired
    CopyService copyService;

    @Autowired
    PersonService personService;

    /**
     * Get all loans by person id
     * @param personId
     * @return
     */
    @RequestMapping(value = {"/myLoans/{personId}"}, method = RequestMethod.GET)
    public Set<Loan> getLoansById(@PathVariable Long personId) {
        LOGGER.info("getLoansById was called");
        Person person;
        Set<Loan> loans = null;
        try {
            person = personService.getPerson(personId).orElseThrow (() ->
                    new LoanNotFoundException("There is no person in database with this id "+personId));
            try {
                loans = person.getLoans();
            } catch(Exception e) {
                LOGGER.error("There is no loans for this person id "+personId+" "+e);
                throw new LoanNotFoundException("There is no loans for this person id "+personId+" "+e);
            }
        }
        catch(Exception e) {
            LOGGER.error("There is no person in database with this id "+personId+" "+e);
        }

        return loans;
    }

    /**
     * Set a loan by copy id
     * @param copyId
     * @return
     */
    @RequestMapping(value = {"/loan"}, method = RequestMethod.POST)
    public Loan setLoan(
            @RequestParam Long copyId
    ) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Copy copy = null;
        try {
            copy = copyService.getCopy(copyId).orElseThrow (() ->
                    new LoanNotFoundException("There is no copy in database with this id "+copyId));
            if(copy.getIsAvailable()==0) {
                LOGGER.info("This copy "+copyId+" is already loan");
                return null;
            }
            copy.setIsAvailable(1);
            copyService.updateCopy(copyId, copy);
        } catch(Exception e) {
            LOGGER.error("There is no copy in database with this id "+copyId+" "+e);
        }

        Loan loan = new Loan();
        loan.setDate(formatter.format(date));
        loan.setIsSecondLoan(0);
        loan.setCopy(copy);

        loanService.addLoan(loan);

        return loan;
    }

    /**
     * Extend a loan by loan id
     * @param loanId
     * @return
     */
    @RequestMapping(value = {"/extendLoan"}, method = RequestMethod.POST)
    public Loan extendLoan(
            @RequestParam Long loanId
    ) {
        Loan loan = null;
        try {
            loan = loanService.getLoan(loanId).orElseThrow (() ->
                    new LoanNotFoundException("There is no loan in database with this id "+loanId));
            if(loan.getIsSecondLoan()==1) {
                LOGGER.info("This is your second loan, you can't extend anymore");
                return null;
            }

            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            loan.setIsSecondLoan(1);
            loan.setDate(formatter.format(date));
            loanService.updateLoan(loanId, loan);

        } catch(Exception e) {
            LOGGER.error("There is no loan in database with this id "+loanId+" "+e);
        }

        return loan;
    }
}
