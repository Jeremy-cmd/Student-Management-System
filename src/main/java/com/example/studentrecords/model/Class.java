package com.example.studentrecords.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CLASS")
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "classes")
    private List<Student> students;

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
