package com.example.Student_Management_App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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

    public String addTeacher(Teacher teacher) {
        studentRepository.addTeacher(teacher);
        return "Teacher added successfully!";
    }

    public Teacher getTeacher(String name) {
        return studentRepository.getTeacher(name);
    }


    public List<String> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public void deleteTeacher(String name) {
        studentRepository.deleteTeacher(name);
    }

    public void addTeacherStudentPair(Integer sId, Integer tId) {
        studentRepository.addTeacherStudentPair(sId, tId);
    }

    public List<String> getStudentByTeacherId(Integer tId) {
        return studentRepository.getStudentByTeacherId(tId);
    }
}
