package com.awareqwx.License.services;

import java.util.ArrayList;

import com.awareqwx.License.models.License;
import com.awareqwx.License.models.Person;
import com.awareqwx.License.repositories.LicenseRepository;
import com.awareqwx.License.repositories.PersonRepository;

public class LicenseService
{

    private LicenseRepository lr;
    private PersonRepository pr;
    
    public LicenseService(LicenseRepository lr, PersonRepository pr)
    {
        this.lr = lr;
        this.pr = pr;
    }
    
    public ArrayList<License> allLicenses()
    {
        return lr.findAll();
    }
    public License findLicenseById(long id)
    {
        return lr.findOne(id);
    }

    public ArrayList<Person> allPersons()
    {
        return pr.findAll();
    }
    public Person findPersonById(long id)
    {
        return pr.findOne(id);
    }

    public void addPerson(Person person)
    {
        pr.save(person);
    }

    public void addLicense(License license)
    {
        lr.save(license);
    }

}
