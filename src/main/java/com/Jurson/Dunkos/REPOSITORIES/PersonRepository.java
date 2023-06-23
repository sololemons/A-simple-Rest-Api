package com.Jurson.Dunkos.REPOSITORIES;

import com.Jurson.Dunkos.ENTITY.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Integer> {
}
