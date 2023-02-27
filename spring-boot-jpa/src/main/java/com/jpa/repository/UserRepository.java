package com.jpa.repository;

import com.jpa.entity.User;
import com.jpa.model.UserOnlyName;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    UserOnlyName findByLastName(String name);

    List<User> findByEmail(String email);

    @Query("From User where lastName=:name")
    User findByQuery(@Param("name") String nameParam);

    @Query("select u from User u where u.lastName like %?1")
    List<User> findByLastNameEndsWith(String lastName);

    List<User> findByLastNameOrderByLastName(String lastName);

    @Query(value = "select u from User u where u.lastName = ?1")
    Page<User> findByLastName(String lastname, Pageable pageable);




}
