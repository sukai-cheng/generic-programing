package com.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "STUDENT")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "tid")
    private Teacher teacher;
}
