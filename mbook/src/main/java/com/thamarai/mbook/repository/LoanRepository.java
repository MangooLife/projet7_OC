package com.thamarai.mbook.repository;

import com.thamarai.mbook.entity.Loan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Long> {

}
