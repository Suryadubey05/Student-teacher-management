package com.example.Student_Management_App;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {
    Map<Integer, Student> studentDb = new HashMap<>();

    public Student getStudent(int id){
        return studentDb.get(id);
    }

    public Student getStudentByPathVariable(int id){
        return studentDb.get(id);
    }

    public void addStudent(Student student){
        studentDb.put(student.getId(), student);

    }

}
