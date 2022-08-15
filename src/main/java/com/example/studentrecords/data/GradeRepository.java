package com.example.studentrecords.data;

import com.example.studentrecords.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer> {

    @Modifying
    @Query(value = "DELETE FROM GRADE g WHERE g.student_id = ?1", nativeQuery = true)
    void deleteGrades(int studentId);



}
