package com.awareqwx.License.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.awareqwx.License.models.Person;

public interface PersonRepository extends CrudRepository<Person, Long>
{
    public ArrayList<Person> findAll();
}
