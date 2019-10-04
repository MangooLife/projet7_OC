package com.thamarai.mbook.repository;

import com.thamarai.mbook.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

}
