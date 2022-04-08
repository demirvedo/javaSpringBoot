package com.vedatdemirdev.api;

import com.vedatdemirdev.entity.Person;
import com.vedatdemirdev.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonRepository personRepository;

    @PostConstruct
    public void init(){
        Person person = new Person();
        person.setName("Vedat");
        person.setSurname("Demir");
        person.setAddress("test");
        person.setBirthDate(Calendar.getInstance().getTime());
        person.setId("K0001");
        personRepository.save(person);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Person>> getPersons(@PathVariable String search){
       List<Person> personList = personRepository.findByNameLikeOrSurnameLike(search,search);
       return ResponseEntity.ok(personList);
    }
}
