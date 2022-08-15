package com.example.studentrecords.controllers;

import com.example.studentrecords.data.GradeRepository;
import com.example.studentrecords.model.Grade;
import com.example.studentrecords.service.StudentRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    StudentRecordsService studentRecordsService;

    @GetMapping
    public ResponseEntity<List<Grade>> allGrades(){
        return new ResponseEntity<>(studentRecordsService.allGrades(), HttpStatus.OK);
    }

    @PostMapping("/createGrade")
    public ResponseEntity<Grade> createGrade(@RequestBody Grade grade) {

        Grade newGrade = studentRecordsService.createGrade(grade);

        return new ResponseEntity<>(newGrade, HttpStatus.CREATED);
    }

    @PutMapping("/updateGrade/{gradeId}/{grade}")
    public ResponseEntity<Grade> updateGrade(@PathVariable int gradeId, @PathVariable int grade) {

        Grade gradeToUpdate = studentRecordsService.updateGrade(gradeId, grade);

        if(gradeToUpdate != null){
            return new ResponseEntity<>(gradeToUpdate, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/deleteGrade/{gradeId}")
    public void deleteGrade(@PathVariable int gradeId) {

        studentRecordsService.deleteGrade(gradeId);

    }


}
