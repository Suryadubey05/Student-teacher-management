package com.example.Student_Management_App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    //API endpoint

    @GetMapping("/get-student")
    public ResponseEntity getStudent(@RequestParam("id") int id){
        Student student = studentService.getStudent(id);
        return new ResponseEntity(student, HttpStatus.OK);
    }

    @GetMapping("/get-student-by-path/{id}")
    public ResponseEntity getStudentByPathVariable(@PathVariable("id") int id){
        Student student = studentService.getStudentByPathVariable(id);
        return new ResponseEntity(student, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody Student student){
        String response = studentService.addStudent(student);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

}
