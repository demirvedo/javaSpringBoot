package com.vedatdemirdev;

import java.util.List;

public class PetController {

    private final PersonService personService;

    @PostMapping
    public ResponseEntity<PersonDto> save(@RequestBody PersonDto personDto){
        return ResponseEntity.ok(personService.save(personDto));
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> listAll(PersonDto personDto){
        return ResponseEntity.ok(personService.getAll());
    }
}
