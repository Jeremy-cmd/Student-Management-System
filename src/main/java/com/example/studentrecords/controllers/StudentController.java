package com.example.studentrecords.controllers;

import com.example.studentrecords.data.GradeRepository;
import com.example.studentrecords.data.StudentRepository;
import com.example.studentrecords.model.Grade;
import com.example.studentrecords.model.Student;
import com.example.studentrecords.service.StudentRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/studentrecords")
public class StudentController {

    @Autowired
    StudentRecordsService studentRecordsService;

    @GetMapping("/allStudents")
    public ResponseEntity<List<Student>> getAllStudents(){

        return ResponseEntity.ok(studentRecordsService.allStudents());
    }

    @GetMapping("/find/{classId}/{low}/{high}")
    public ResponseEntity<List<Student>> studentsWithinRange(@PathVariable int classId, @PathVariable int low, @PathVariable int high) {

        return ResponseEntity.ok(studentRecordsService.getStudentsInRange(classId, low, high));
    }


    @PostMapping("/createStudent")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){

        Student newStudent = studentRecordsService.createStudent(student);

        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);

    }

    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {

        Student updatedStudent = studentRecordsService.updateStudent(id, student);

        if(updatedStudent != null){
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);

        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/deleteStudent/{studentId}")
    public void deleteStudent(@PathVariable int studentId){

        studentRecordsService.deleteStudent(studentId);
    }

}

  