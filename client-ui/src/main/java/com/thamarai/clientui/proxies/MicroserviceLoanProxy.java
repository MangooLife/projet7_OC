package com.thamarai.clientui.proxies;

import com.thamarai.clientui.entity.Loan;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(contextId = "microserviceLoanProxy", name = "zuul-server")
public interface MicroserviceLoanProxy {

    /**
     * Get all loans by person id
     * @param personId
     * @return Set<Loan>
     */
    @RequestMapping(value = {"/microservice-loan/myLoans/{personId}"}, method = RequestMethod.GET)
    List<Loan> getLoansById(@PathVariable Long personId);

    /**
     * Get all loans
     * @return List<Loan>
     */
    @RequestMapping(value = {"/microservice-loan/allLoans"}, method = RequestMethod.GET)
    @ResponseBody List<Loan> getAllLoans();

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
    @RequestMapping(value = {"/microservice-loan/extendLoan/{loanId}"}, method = RequestMethod.POST)
    Loan extendLoan(@PathVariable Long loanId);
}
