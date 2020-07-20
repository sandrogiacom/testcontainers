package com.giacom.tc.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.giacom.tc.demo.domain.SampleUser;

@Repository
public interface SampleUserRepository extends CrudRepository<SampleUser, String> {

    List<SampleUser> findByNameContainingIgnoreCase(String name);

    List<SampleUser> findByLastNameContainingIgnoreCase(String lastName);

}
