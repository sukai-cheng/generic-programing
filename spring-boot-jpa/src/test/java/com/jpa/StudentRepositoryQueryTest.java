package com.jpa;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jpa.entity.Student;
import com.jpa.entity.Teacher;
import com.jpa.repository.StudentRepository;
import com.jpa.repository.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@DataJpaTest
@Slf4j
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StudentRepositoryQueryTest {
    @Resource
    private StudentRepository studentRepository;

    @Resource
    private TeacherRepository teacherRepository;

    @BeforeAll
    @Rollback(value = false)
    @Transactional
    void init() {
        Teacher teacher = Teacher.builder().name("Lily").build();
        Student student1 = Student.builder().name("John").teacher(teacher).build();
        Student student2 = Student.builder().name("Jack").teacher(teacher).build();
        teacherRepository.save(teacher);
        studentRepository.saveAll(Lists.newArrayList(student1,student2));
    }

    @Test
    @Rollback(value = false)
    public void testStudentRelationShips() throws JsonProcessingException {
//        Student student = studentRepository.getOne(3L);
//        System.out.println(student.getName());
//        System.out.println(student.getTeacher());
        Teacher teacher = teacherRepository.getOne(1L);
        System.out.println(teacher.getStudents());
    }


}
