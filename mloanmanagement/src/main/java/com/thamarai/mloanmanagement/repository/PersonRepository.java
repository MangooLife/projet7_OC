package com.thamarai.mloanmanagement.repository;

import com.thamarai.mloanmanagement.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

}
