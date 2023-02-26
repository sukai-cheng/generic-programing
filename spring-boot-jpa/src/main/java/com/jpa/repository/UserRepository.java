package com.jpa.repository;

import com.jpa.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByLastName(String name);

    List<User> findByEmail(String email);

}
