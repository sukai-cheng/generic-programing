package com.jpa.repository;

import com.jpa.entity.User;
import com.jpa.model.UserOnlyName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    UserOnlyName findByLastName(String name);

    List<User> findByEmail(String email);

    @Query("From User where lastName=:name")
    User findByQuery(@Param("name") String nameParam);


}
