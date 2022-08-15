package com.example.studentrecords.data;

import com.example.studentrecords.model.Student;

public interface StudentRecordsDao {

    public Student createStudent(String first_name, String last_name);
}
