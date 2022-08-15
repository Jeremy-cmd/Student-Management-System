package com.example.studentrecords.data;

import com.example.studentrecords.model.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@RestController
@RequestMapping("/studentrecords")
public class StudentRecordsDaoImpl implements StudentRecordsDao {


    @Override
    public Student createStudent(String first_name, String last_name) {
        return null;
    }
}
