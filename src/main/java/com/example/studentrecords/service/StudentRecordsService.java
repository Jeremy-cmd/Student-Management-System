package com.example.studentrecords.service;

import com.example.studentrecords.data.StudentRepository;
import com.example.studentrecords.model.Grade;
import com.example.studentrecords.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRecordsService {

    public List<Student> allStudents();

    public List<Student> getStudentsInRange(int classId, int low, int high);

    public Student createStudent(Student student);

    public Student updateStudent(int studentId, Student student);

    public void deleteStudent(int studentId);

    public List<Grade> allGrades();

    public Grade createGrade(Grade grade);

    public Grade updateGrade(int gradeId, int grade);

    public void deleteGrade(int gradeId);



}
