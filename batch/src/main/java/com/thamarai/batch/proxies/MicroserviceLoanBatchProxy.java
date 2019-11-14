package com.thamarai.batch.proxies;

import com.thamarai.batch.entity.Loan;
import com.thamarai.batch.entity.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@FeignClient(contextId = "microserviceLoanBatchProxy", name = "zuul-server")
public interface MicroserviceLoanBatchProxy {

    /**
     * Get all loans by person id
     * @param personId
     * @return Set<Loan>
     */
    @RequestMapping(value = {"/microservice-loan/myLoans/{personId}"}, method = RequestMethod.GET)
    Set<Loan> getLoansById(@PathVariable Long personId);

    /**
     * Get all loans
     * @return List<Loan>
     */
    @RequestMapping(value = {"/microservice-loan/allLoans"}, method = RequestMethod.GET)
    List<Loan> getAllLoans();

    /**
     * Get all loans's person
     * @return List<Person>
     */
    @RequestMapping(value = {"/microservice-loan/allLoansPersonsLate"}, method = RequestMethod.GET)
    List<Person> getAllLoansPersonsLate();

    /**
     * Set a loan by copy id
     * @param copyId
     * @return Loan
     */
    @RequestMapping(value = {"/microservice-loan/loan"}, method = RequestMethod.POST)
    Loan setLoan(@RequestParam Long copyId);

    /**
     * Extend a loan by loan id
     * @param loanId
     * @return Loan
     */
    @RequestMapping(value = {"/microservice-loan/extendLoan"}, method = RequestMethod.POST)
    Loan extendLoan(@RequestParam Long loanId);

    /**
     * Get Loan's person
     * @param loanId
     * @return
     */
    @RequestMapping(value = {"/getLoanPerson/{loanId}"}, method = RequestMethod.GET)
    List<Person> loanPerson(@PathVariable Long loanId);
}
