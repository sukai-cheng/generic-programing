package com.jpa.repository;

import com.jpa.entity.User;
import com.jpa.model.UserDto;
import com.jpa.model.UserOnlyName;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByEmail(String email);

    @Query("From User where lastName=:name")
    User findByQuery(@Param("name") String nameParam);

    @Query("select u from User u where u.lastName like %?1")
    List<User> findByLastNameEndsWith(String lastName);

    List<User> findByLastNameOrderByLastName(String lastName);

    @Query(value = "select u from User u where u.lastName = ?1")
    Page<User> findByLastName(String lastname, Pageable pageable);

    @Query(value = "select CONCAT(u.firstName, 'simon') as name, UPPER(u.email) as email, e.idCard as idCard " +
            "from User u, UserExtend e " +
            "where u.id = e.userId and u.id = :id")
    UserDto findByUserDtoId(@Param("id") Long id);

    UserOnlyName findByLastName(String name);

    @Query("select u.firstName as firstName, u.email as email from User u where (:name is null or u.firstName = :name) and (:email is null or u.email = :email)")
    UserOnlyName findByUser(@Param("name") String name, @Param("email") String email);


}
