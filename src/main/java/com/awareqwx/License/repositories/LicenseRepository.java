package com.awareqwx.License.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.awareqwx.License.models.License;

public interface LicenseRepository extends CrudRepository<License, Long>
{
    public ArrayList<License> findAll();
}
