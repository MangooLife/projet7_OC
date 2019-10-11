package com.thamarai.clientui.proxies;

import com.thamarai.clientui.entity.Loan;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@FeignClient(name = "microservice-loan", url = "localhost:9092")
public interface MicroserviceLoanProxy {

    /**
     * Get all loans by person id
     * @param personId
     * @return Set<Loan>
     */
    @RequestMapping(value = {"/myLoans/{personId}"}, method = RequestMethod.GET)
    Set<Loan> getLoansById(@PathVariable Long personId);

    /**
     * Set a loan by copy id
     * @param copyId
     * @return Loan
     */
    @RequestMapping(value = {"/loan"}, method = RequestMethod.POST)
    Loan setLoan(@RequestParam Long copyId);

    /**
     * Extend a loan by loan id
     * @param loanId
     * @return Loan
     */
    @RequestMapping(value = {"/extendLoan"}, method = RequestMethod.POST)
    Loan extendLoan(@RequestParam Long loanId);
}
