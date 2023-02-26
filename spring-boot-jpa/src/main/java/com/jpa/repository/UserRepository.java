package com.jpa.repository;

import com.jpa.entity.User;
import com.jpa.model.UserOnlyName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    UserOnlyName findByLastName(String name);

    List<User> findByEmail(String email);



}
