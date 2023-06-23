package com.Jurson.Dunkos.SERVICES;

import com.Jurson.Dunkos.ENTITY.Person;
import com.Jurson.Dunkos.EXCEPTIONS.ResoureNotFoundException;
import com.Jurson.Dunkos.REPOSITORIES.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service

public class PersonService  {
    private PersonRepository personRepository;
    @Autowired

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public List<Person>getAllPerson(){
      return   personRepository.findAll();

    }

    public void addNewPerson(Person person) {
        personRepository.save(person);
    }
    public ResponseEntity<Person> getPersonbyid(@PathVariable Integer id){
        Person person=personRepository.findById(id).orElseThrow(()->new ResoureNotFoundException("Person does not exist with id :"+id));
       return  ResponseEntity.ok(person);

    }
    public ResponseEntity<Person>updatePerson(@PathVariable Integer id,@RequestBody Person personDetails){
        Person updatePerson=personRepository.findById(id).orElseThrow(()-> new ResoureNotFoundException("Person does not exsist in our database with id:"+id));

        updatePerson.setId(personDetails.getId());
        updatePerson.setFirst_name(personDetails.getFirst_name());
        updatePerson.setLast_name(personDetails.getLast_name());
        updatePerson.setState(personDetails.getState());
        updatePerson.setAge(personDetails.getAge());

        personRepository.save(updatePerson);
        return ResponseEntity.ok(updatePerson);

    }
    public ResponseEntity<HttpStatus>deletePerson(@PathVariable Integer id){
        Person person=personRepository.findById(id) .orElseThrow(() -> new ResoureNotFoundException("Person does not exsist in our database with Id :"+id));
        personRepository.delete(person);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




    }


