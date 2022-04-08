package com.vedatdemirdev.repository;

import com.vedatdemirdev.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
