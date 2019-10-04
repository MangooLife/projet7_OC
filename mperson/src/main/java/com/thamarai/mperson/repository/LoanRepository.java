package com.thamarai.mperson.repository;

import com.thamarai.mperson.entity.Loan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Long> {

}
