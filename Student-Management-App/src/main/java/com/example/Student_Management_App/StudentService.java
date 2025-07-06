package com.example.Student_Management_App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student getStudent(int id){
        return studentRepository.getStudent(id);
    }

    public Student getStudentByPathVariable(int id){
        return studentRepository.getStudentByPathVariable(id);
    }

    public String addStudent(Student student){
        studentRepository.addStudent(student);
        return "Student added successfully!";
    }

}
