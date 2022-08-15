package com.example.studentrecords.service;

import com.example.studentrecords.data.GradeRepository;
import com.example.studentrecords.data.StudentRepository;
import com.example.studentrecords.model.Grade;
import com.example.studentrecords.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentRecordsServiceImpl implements StudentRecordsService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    GradeRepository gradeRepository;


    @Override
    public List<Student> allStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getStudentsInRange(int classId, int low, int high) {
        return studentRepository.getStudents(classId, low, high);
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(int studentId, Student student) {

        Optional<Student> studentToUpdate = studentRepository.findById(studentId);

        if(studentToUpdate.isPresent()){
            Student oldStudent = studentToUpdate.get();
            oldStudent.setFirst_name(student.getFirst_name());
            oldStudent.setLast_name(student.getLast_name());
            return studentRepository.save(oldStudent);
        }
        else{
            return null;
        }

    }

    @Override
    @Transactional
    public void deleteStudent(int studentId) {

        Optional<Student> student = studentRepository.findById(studentId);
        gradeRepository.deleteGrades(studentId);
        studentRepository.deleteById(studentId);

    }

    @Override
    public List<Grade> allGrades() {
        return gradeRepository.findAll();
    }

    @Override
    public Grade createGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    @Override
    public Grade updateGrade(int gradeId, int grade) {

        Optional<Grade> gradeToUpdate = gradeRepository.findById(gradeId);

        if(gradeToUpdate.isPresent()){
            Grade oldGrade = gradeToUpdate.get();
            oldGrade.setScore(grade);
            return gradeRepository.save(oldGrade);
        }
        else{
            return null;
        }

    }

    @Override
    public void deleteGrade(int gradeId) {
        gradeRepository.deleteById(gradeId);
    }
}
