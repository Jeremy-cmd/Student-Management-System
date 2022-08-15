package com.example.studentrecords.data;

import com.example.studentrecords.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "SELECT * FROM STUDENT s JOIN GRADE g ON s.id = g.student_id JOIN CLASS c ON c.id = ?1 " +
            "WHERE g.score BETWEEN ?2 AND ?3",
    nativeQuery = true)
    List<Student> getStudents(int classId, int low, int high);




}
