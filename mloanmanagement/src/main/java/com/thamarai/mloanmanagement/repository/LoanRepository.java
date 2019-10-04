package com.thamarai.mloanmanagement.repository;

import com.thamarai.mloanmanagement.entity.Loan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Long> {

}
