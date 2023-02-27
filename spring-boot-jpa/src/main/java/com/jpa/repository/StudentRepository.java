package com.jpa.repository;

import com.jpa.entity.Student;
import com.jpa.entity.UserExtend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
