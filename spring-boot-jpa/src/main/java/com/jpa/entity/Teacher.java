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

    // mapperBy指定的是另一方实体里面属性字段
    @OneToMany(mappedBy = "teacher")
//    @org.hibernate.annotations.ForeignKey(name = "none")
    private List<Student> students;
}
