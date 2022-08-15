package com.example.studentrecords.model;

import javax.persistence.*;

@Entity
@Table(name = "GRADE")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "student_id", updatable = false, insertable = false)
    private Student student;

    @Column
    private int student_id;


    @ManyToOne
    @JoinColumn(name = "class_id", updatable = false, insertable = false)
    private Class aClass;

    @Column
    private int class_id;

    @Column(name = "score")
    private int score;

    public Grade(){

    }

    public Integer getId() {
        return id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public Class getaClass() {
        return aClass;
    }
}
