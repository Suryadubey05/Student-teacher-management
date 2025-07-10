package com.example.Student_Management_App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    //API endpoint

    @GetMapping("/get-student")
    public ResponseEntity<Student> getStudent(@RequestParam("id") int id){
        Student student = studentService.getStudent(id);
        return new ResponseEntity(student, HttpStatus.OK);
    }

    @GetMapping("/get-student-by-path/{id}")
    public ResponseEntity getStudentByPathVariable(@PathVariable("id") int id){
        Student student = studentService.getStudentByPathVariable(id);
        return new ResponseEntity(student, HttpStatus.OK);
    }

    @PostMapping("/add-student")
    public ResponseEntity addStudent(@RequestBody Student student){
        String response = studentService.addStudent(student);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }





    //-----------------------Teacher---------------------------------------

    @PostMapping("/add-teacher")
    public ResponseEntity<String> addTeacher(@RequestBody Teacher teacher){
        String response = studentService.addTeacher(teacher);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/get-teacher/{name}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable("name")  String name){
        Teacher teacher = studentService.getTeacher(name);
        return new ResponseEntity<>(teacher, HttpStatus.FOUND);
    }

    /* --------------------------------------Assignment--------------------------------*/

    @GetMapping("/get-all-students")
    public ResponseEntity<List<String>> getAllStudents(){
            List<String> allStudents = studentService.getAllStudents();
            return new ResponseEntity<>(allStudents, HttpStatus.FOUND);
    }

    @DeleteMapping("/delete-teacher")
    public ResponseEntity deleteTeacher(@RequestParam("name") String name){
        studentService.deleteTeacher(name);
        return new ResponseEntity<>("Teacher " +name+ " deleted!",HttpStatus.ACCEPTED );
    }

    @PutMapping("/add-teacher-students-pair")
    public ResponseEntity<String> addTeacherStudentPair(@RequestParam Integer SId,
                                                        @RequestParam Integer TId){

            studentService.addTeacherStudentPair(SId, TId);

            return new ResponseEntity<>("student - teacher added successfully ", HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-students-by-teacher-id/{tId}")
    public ResponseEntity<List<String>> getStudentByTeacherId(@PathVariable Integer tId){
        List<String> studentsList = studentService.getStudentByTeacherId(tId);
        return new ResponseEntity<>(studentsList, HttpStatus.FOUND);
    }

}
