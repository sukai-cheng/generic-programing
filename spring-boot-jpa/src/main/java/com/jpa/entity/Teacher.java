package com.jpa.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TEACHER")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "teacher")
    private List<Student> students;
}
