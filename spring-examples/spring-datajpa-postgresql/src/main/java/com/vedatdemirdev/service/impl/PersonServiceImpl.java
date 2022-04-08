package com.vedatdemirdev.service.impl;

import com.vedatdemirdev.dto.PersonDto;
import com.vedatdemirdev.entity.Address;
import com.vedatdemirdev.entity.Person;
import com.vedatdemirdev.repository.AddressRepository;
import com.vedatdemirdev.repository.PersonRepository;
import com.vedatdemirdev.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    @Override
    @Transactional
    public PersonDto save(PersonDto personDto) {

        Assert.isNull(personDto.getName(), "Name cannot be null!!");

        Person person = new Person();
        person.setName(personDto.getName());
        person.setSurname(personDto.getSurname());
        final Person personDb = personRepository.save(person);

        List<Address> addressList = new ArrayList<>();
        personDto.getAddresses().forEach(item ->{
            Address address = new Address();
            address.setAddress(item);
            address.setAdressType(Address.AddressType.OTHER);
            address.setIsActive(true);
            address.setPerson(personDb);
            addressList.add(address);
        });
        addressRepository.saveAll(addressList);
        return personDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<PersonDto> getAll() {
        List<Person> personList = personRepository.findAll();
        List<PersonDto> personDtos = new ArrayList<>();

        personList.forEach(item ->{
            PersonDto personDto = new PersonDto();
            personDto.setId(item.getId());
            personDto.setName(item.getName());
            personDto.setSurname(item.getSurname());
            personDto.setAddresses(item.getAddresses().stream().map(Address::getAddress).collect(Collectors.toList()));
            personDtos.add(personDto);
        });
        return personDtos;
    }

    @Override
    public Page<PersonDto> getAll(Pageable pageable) {
        return null;
    }
}
